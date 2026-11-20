package com.portfolio.mlops.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "prediction_audit_logs")
public class PredictionAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicationId;
    private double creditAmount;
    private int durationMonths;
    private double defaultProbability;
    private String riskDecision;
    private boolean dataDriftDetected;
    private String modelVersion;
    private Instant createdAt;

    public PredictionAuditLog() {}

    public PredictionAuditLog(String applicationId, double creditAmount, int durationMonths,
                              double defaultProbability, String riskDecision,
                              boolean dataDriftDetected, String modelVersion) {
        this.applicationId = applicationId;
        this.creditAmount = creditAmount;
        this.durationMonths = durationMonths;
        this.defaultProbability = defaultProbability;
        this.riskDecision = riskDecision;
        this.dataDriftDetected = dataDriftDetected;
        this.modelVersion = modelVersion;
        this.createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public String getApplicationId() { return applicationId; }
    public double getCreditAmount() { return creditAmount; }
    public int getDurationMonths() { return durationMonths; }
    public double getDefaultProbability() { return defaultProbability; }
    public String getRiskDecision() { return riskDecision; }
    public boolean isDataDriftDetected() { return dataDriftDetected; }
    public String getModelVersion() { return modelVersion; }
    public Instant getCreatedAt() { return createdAt; }
}
