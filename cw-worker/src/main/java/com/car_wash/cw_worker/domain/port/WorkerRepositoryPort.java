package com.car_wash.cw_worker.domain.port;

import java.util.List;
import java.util.Optional;

import com.car_wash.cw_worker.domain.model.Worker;

public interface WorkerRepositoryPort {

    List<Worker> findAll();

    Optional<Worker> findById(Long id);

    Worker save(Worker worker);

    void deleteById(Long id);
}
