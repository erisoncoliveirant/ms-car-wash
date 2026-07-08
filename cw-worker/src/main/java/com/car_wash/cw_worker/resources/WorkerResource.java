package com.car_wash.cw_worker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car_wash.cw_worker.entities.Worker;
import com.car_wash.cw_worker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = workerRepository.findAll();
		return ResponseEntity.ok(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> getById(@PathVariable("id") String id) {
		Worker worker = workerRepository.findById(Long.parseLong(id)).get();
		return ResponseEntity.ok(worker);
	}
}
