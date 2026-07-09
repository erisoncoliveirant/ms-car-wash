package com.car_wash.cw_worker.domain.exception;

public class WorkerNotFoundException extends RuntimeException {

    public WorkerNotFoundException(Long id) {
        super("Worker not found: " + id);
    }
}
