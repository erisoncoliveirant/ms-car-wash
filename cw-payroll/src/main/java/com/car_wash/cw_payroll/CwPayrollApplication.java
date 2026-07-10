package com.car_wash.cw_payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CwPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(CwPayrollApplication.class, args);
	}

}
