package com.car_wash.cw_payroll.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.car_wash.cw_payroll.entities.Payment;
import com.car_wash.cw_payroll.entities.Worker;
import com.car_wash.cw_payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
	
	@Value("${cw-work.host}")
	private String workerHost;
	
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(Long workId, Integer days) {		
		Worker worker = workerFeignClient.getById(workId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
