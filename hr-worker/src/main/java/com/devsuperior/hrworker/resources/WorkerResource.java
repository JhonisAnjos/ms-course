package com.devsuperior.hrworker.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/workers")
@AllArgsConstructor
public class WorkerResource {
	
	private WorkerRepository repository;
	
	@GetMapping
	private ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = this.repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	private ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker obj = this.repository.findById(id).get();
		return ResponseEntity.ok().body(obj);
	}

}
