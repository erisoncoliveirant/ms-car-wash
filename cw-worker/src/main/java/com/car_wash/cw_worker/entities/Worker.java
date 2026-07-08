package com.car_wash.cw_worker.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_worker")
public class Worker implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private Double dailyIncome;
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Double getDailyIncome() {
		return dailyIncome;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}	
	
}
