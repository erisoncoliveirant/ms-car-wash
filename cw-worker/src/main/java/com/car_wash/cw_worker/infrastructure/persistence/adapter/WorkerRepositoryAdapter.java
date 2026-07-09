package com.car_wash.cw_worker.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.car_wash.cw_worker.domain.model.Worker;
import com.car_wash.cw_worker.domain.port.WorkerRepositoryPort;
import com.car_wash.cw_worker.infrastructure.persistence.jpa.WorkerEntity;
import com.car_wash.cw_worker.infrastructure.persistence.jpa.WorkerJpaRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class WorkerRepositoryAdapter implements WorkerRepositoryPort {

    private final WorkerJpaRepository workerJpaRepository;

    @Override
    public List<Worker> findAll() {
        return workerJpaRepository.findAll().stream()
            .map(WorkerEntity::toDomain)
            .toList();
    }

    @Override
    public Optional<Worker> findById(Long id) {
        return workerJpaRepository.findById(id)
            .map(WorkerEntity::toDomain);
    }

    @Override
    public Worker save(Worker worker) {
        WorkerEntity entity = WorkerEntity.fromDomain(worker);
        return workerJpaRepository.save(entity).toDomain();
    }

    @Override
    public void deleteById(Long id) {
        workerJpaRepository.deleteById(id);
    }
}
