package com.car_wash.cw_worker.interfaces.rest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.car_wash.cw_worker.application.service.WorkerService;
import com.car_wash.cw_worker.domain.model.Worker;

@SpringBootTest
class WorkerControllerTest {

    @Autowired
    private WorkerService workerService;

    @Test
    void shouldCreateWorkerWithoutProvidingId() {
        Worker created = workerService.create(Worker.create("Ana", 150.0));

        assertThat(created.getId()).isNotNull();
        assertThat(created.getName()).isEqualTo("Ana");
        assertThat(created.getDailyIncome()).isEqualTo(150.0);
    }
}
