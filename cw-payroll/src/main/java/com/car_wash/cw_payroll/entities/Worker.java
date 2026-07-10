package com.car_wash.cw_payroll.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Worker {

    private Long id;
    private String name;
    private Double dailyIncome;

    public static Worker create(String name, Double dailyIncome) {
        return new Worker(null, name, dailyIncome);
    }

    public static Worker withId(Long id, String name, Double dailyIncome) {
        return new Worker(id, name, dailyIncome);
    }

    public void update(String name, Double dailyIncome) {
        this.name = name;
        this.dailyIncome = dailyIncome;
    }
}
