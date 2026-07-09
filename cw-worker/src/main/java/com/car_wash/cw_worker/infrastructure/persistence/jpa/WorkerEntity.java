package com.car_wash.cw_worker.infrastructure.persistence.jpa;

import java.io.Serializable;

import com.car_wash.cw_worker.domain.model.Worker;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_worker")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
@ToString
public class WorkerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "daily_income", nullable = false)
    private Double dailyIncome;

    private WorkerEntity(String name, Double dailyIncome) {
        this.name = name;
        this.dailyIncome = dailyIncome;
    }

    public static WorkerEntity fromDomain(Worker worker) {
        WorkerEntity entity = new WorkerEntity(worker.getName(), worker.getDailyIncome());
        entity.id = worker.getId();
        return entity;
    }

    public Worker toDomain() {
        return Worker.withId(this.id, this.name, this.dailyIncome);
    }
}
