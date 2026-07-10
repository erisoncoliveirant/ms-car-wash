package com.car_wash.cw_payroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car_wash.cw_payroll.entities.Payment;
import com.car_wash.cw_payroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentRsource {
	private PaymentService service;
	
	@GetMapping(value = "/{workId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable("workId") Long workId, @PathVariable("days") Integer days) {
		Payment payment = service.getPayment(workId, days);
		return ResponseEntity.ok(payment);
	}
	
}
