package com.car_wash.cw_worker.interfaces.rest.dto;

import com.car_wash.cw_worker.domain.model.Worker;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class WorkerResponse {

    private Long id;
    private String name;
    private Double dailyIncome;

    public static WorkerResponse fromDomain(Worker worker) {
        return WorkerResponse.builder()
            .id(worker.getId())
            .name(worker.getName())
            .dailyIncome(worker.getDailyIncome())
            .build();
    }
}
