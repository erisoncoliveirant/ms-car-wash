package com.car_wash.cw_worker.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.car_wash.cw_worker.domain.exception.WorkerNotFoundException;
import com.car_wash.cw_worker.domain.model.Worker;
import com.car_wash.cw_worker.domain.port.WorkerRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepositoryPort workerRepository;

    @Transactional(readOnly = true)
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Worker findById(Long id) {
        return workerRepository.findById(id)
            .orElseThrow(() -> new WorkerNotFoundException(id));
    }

    @Transactional
    public Worker create(Worker worker) {
        return workerRepository.save(worker);
    }

    @Transactional
    public Worker update(Long id, Worker worker) {
        Worker existing = findById(id);
        existing.update(worker.getName(), worker.getDailyIncome());
        return workerRepository.save(existing);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        workerRepository.deleteById(id);
    }
}
