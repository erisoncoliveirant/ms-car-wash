package com.car_wash.cw_worker.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerJpaRepository extends JpaRepository<WorkerEntity, Long> {
}
