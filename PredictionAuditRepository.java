package com.portfolio.mlops.repository;

import com.portfolio.mlops.model.PredictionAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PredictionAuditRepository extends JpaRepository<PredictionAuditLog, Long> {
    List<PredictionAuditLog> findByDataDriftDetectedTrue();
}
