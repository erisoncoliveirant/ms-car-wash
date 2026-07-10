package com.car_wash.cw_payroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.car_wash.cw_payroll.entities.Worker;

@Component
@FeignClient(name = "cw-worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClient {
	@GetMapping(value = "/{id}")
    public ResponseEntity<Worker> getById(@PathVariable("id") Long id);
}
