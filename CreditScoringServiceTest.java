package com.portfolio.mlops;

import com.portfolio.mlops.dto.LoanApplicationRequest;
import com.portfolio.mlops.dto.RiskScoreResponse;
import com.portfolio.mlops.repository.PredictionAuditRepository;
import com.portfolio.mlops.service.CreditScoringService;
import com.portfolio.mlops.service.DataDriftMonitorService;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CreditScoringServiceTest {

    private CreditScoringService scoringService;

    @BeforeEach
    void setUp() {
        PredictionAuditRepository mockRepo = Mockito.mock(PredictionAuditRepository.class);
        SimpleMeterRegistry meterRegistry = new SimpleMeterRegistry();
        DataDriftMonitorService driftMonitor = new DataDriftMonitorService(meterRegistry);
        scoringService = new CreditScoringService(mockRepo, driftMonitor, meterRegistry);
    }

    @Test
    void shouldApproveLowRiskApplicationWithoutDrift() {
        LoanApplicationRequest request = new LoanApplicationRequest(
                "APP-TEST-1", "A14", 12, "A34", 2000.0, 45
        );

        RiskScoreResponse response = scoringService.scoreApplication(request);

        assertEquals("APPROVED", response.riskDecision());
        assertFalse(response.dataDriftDetected());
    }

    @Test
    void shouldFlagDataDriftOnUnusuallyLargeLoan() {
        LoanApplicationRequest request = new LoanApplicationRequest(
                "APP-TEST-2", "A11", 48, "A32", 18500.0, 23
        );

        RiskScoreResponse response = scoringService.scoreApplication(request);

        assertEquals("REJECTED", response.riskDecision());
        assertTrue(response.dataDriftDetected());
    }
}
