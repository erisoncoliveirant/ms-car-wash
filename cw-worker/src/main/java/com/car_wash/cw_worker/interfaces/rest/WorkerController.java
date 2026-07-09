package com.car_wash.cw_worker.interfaces.rest;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.car_wash.cw_worker.application.service.WorkerService;
import com.car_wash.cw_worker.domain.model.Worker;
import com.car_wash.cw_worker.interfaces.rest.dto.WorkerRequest;
import com.car_wash.cw_worker.interfaces.rest.dto.WorkerResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<WorkerResponse>> findAll() {
        return ResponseEntity.ok(workerService.findAll().stream()
            .map(WorkerResponse::fromDomain)
            .toList());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerResponse> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(WorkerResponse.fromDomain(workerService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<WorkerResponse> create(@RequestBody WorkerRequest request) {
        Worker created = workerService.create(request.toDomain());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(created.getId())
            .toUri();
        return ResponseEntity.created(location).body(WorkerResponse.fromDomain(created));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<WorkerResponse> update(@PathVariable("id") Long id, @RequestBody WorkerRequest request) {
        Worker updated = workerService.update(id, request.toDomain());
        return ResponseEntity.ok(WorkerResponse.fromDomain(updated));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        workerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
