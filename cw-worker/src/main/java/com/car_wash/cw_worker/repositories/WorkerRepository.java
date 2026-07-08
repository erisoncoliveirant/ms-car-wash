package com.car_wash.cw_worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car_wash.cw_worker.entities.Worker;

import jakarta.transaction.Transactional;

@Transactional
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
