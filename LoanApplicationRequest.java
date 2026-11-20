package com.portfolio.mlops.dto;

import jakarta.validation.constraints.*;

public record LoanApplicationRequest(
        @NotBlank(message = "Application ID is required")
        String applicationId,

        @NotBlank(message = "Checking status code is required (e.g. A11, A12, A14)")
        String checkingStatus,

        @Min(value = 1, message = "Duration must be at least 1 month")
        @Max(value = 120, message = "Duration cannot exceed 120 months")
        int durationMonths,

        @NotBlank(message = "Credit history code is required (e.g. A32, A34)")
        String creditHistory,

        @Positive(message = "Credit amount must be greater than zero")
        double creditAmount,

        @Min(value = 18, message = "Applicant must be at least 18")
        int age
) {}
