package com.pismo.pismotransactions.repository;

import com.pismo.pismotransactions.model.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationTypetRepository extends JpaRepository<OperationType, Long> {
}
