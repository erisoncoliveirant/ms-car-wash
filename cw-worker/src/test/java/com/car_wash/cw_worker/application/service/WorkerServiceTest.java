package com.car_wash.cw_worker.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.car_wash.cw_worker.domain.exception.WorkerNotFoundException;
import com.car_wash.cw_worker.domain.model.Worker;
import com.car_wash.cw_worker.domain.port.WorkerRepositoryPort;

class WorkerServiceTest {

    @Test
    void shouldFindAllWorkers() {
        InMemoryWorkerRepository repository = new InMemoryWorkerRepository();
        repository.save(Worker.create("Bob", 200.0));

        WorkerService service = new WorkerService(repository);

        List<Worker> workers = service.findAll();

        assertEquals(1, workers.size());
        assertEquals("Bob", workers.get(0).getName());
    }

    @Test
    void shouldCreateWorker() {
        InMemoryWorkerRepository repository = new InMemoryWorkerRepository();
        WorkerService service = new WorkerService(repository);

        Worker created = service.create(Worker.create("Ana", 150.0));

        assertNotNull(created.getId());
        assertEquals("Ana", created.getName());
        assertEquals(150.0, created.getDailyIncome());
    }

    @Test
    void shouldDeleteExistingWorker() {
        InMemoryWorkerRepository repository = new InMemoryWorkerRepository();
        repository.save(Worker.withId(1L, "Bob", 200.0));
        WorkerService service = new WorkerService(repository);

        service.delete(1L);

        assertThrows(WorkerNotFoundException.class, () -> service.findById(1L));
    }

    @Test
    void shouldThrowWhenWorkerDoesNotExist() {
        WorkerService service = new WorkerService(new InMemoryWorkerRepository());

        WorkerNotFoundException exception = assertThrows(
            WorkerNotFoundException.class,
            () -> service.findById(99L)
        );

        assertEquals("Worker not found: 99", exception.getMessage());
    }

    private static class InMemoryWorkerRepository implements WorkerRepositoryPort {
        private final List<Worker> workers = new ArrayList<>();

        @Override
        public List<Worker> findAll() {
            return new ArrayList<>(workers);
        }

        @Override
        public Optional<Worker> findById(Long id) {
            return workers.stream().filter(worker -> worker.getId().equals(id)).findFirst();
        }

        @Override
        public Worker save(Worker worker) {
            Worker saved = Worker.withId(
                worker.getId() == null ? (long) (workers.size() + 1) : worker.getId(),
                worker.getName(),
                worker.getDailyIncome()
            );
            workers.removeIf(existing -> existing.getId() != null && existing.getId().equals(saved.getId()));
            workers.add(saved);
            return saved;
        }

        @Override
        public void deleteById(Long id) {
            workers.removeIf(worker -> worker.getId() != null && worker.getId().equals(id));
        }
    }
}
