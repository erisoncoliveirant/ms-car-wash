package com.car_wash.cw_worker.interfaces.rest.dto;

import com.car_wash.cw_worker.domain.model.Worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class WorkerRequest {

    private String name;
    private Double dailyIncome;

    public Worker toDomain() {
        return Worker.create(this.name, this.dailyIncome);
    }
}
