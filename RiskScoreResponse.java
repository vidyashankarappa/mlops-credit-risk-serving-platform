package com.portfolio.mlops.dto;

import java.time.Instant;

public record RiskScoreResponse(
        String applicationId,
        double defaultProbability,
        String riskDecision,      // APPROVED, MANUAL_REVIEW, or REJECTED
        boolean dataDriftDetected,
        String modelVersion,
        Instant scoredAt
) {}
