# MLOps Credit Risk Serving & Drift Monitoring Platform

A production-style **Java 17 & Spring Boot** ML inference gateway trained around the **UCI German Credit Dataset**, featuring real-time and CSV batch scoring, SQL compliance audit trails, Z-score data drift detection, and **Prometheus/Actuator** observability.

## Architecture
```mermaid
flowchart LR
    Client[Loan Application Client] -->|POST /api/v1/risk/score| API[Spring Boot Inference API]
    API --> Drift[Z-Score Data Drift Monitor]
    API --> DB[(SQL Compliance Audit Log)]
    API --> Prom[/actuator/prometheus Telemetry]
```

## Key Endpoints
* `POST /api/v1/risk/score` — Real-time JSON credit risk scoring with input validation.
* `POST /api/v1/risk/score/batch` — Bulk CSV scoring (`data/german_credit_sample.csv`).
* `GET /api/v1/risk/audit` — Full historical prediction audit trail for banking compliance.
* `GET /api/v1/risk/drift-alerts` — Lists loan requests flagged for statistical feature drift.
* `GET /actuator/prometheus` — Live inference latency and drift alert counters.
