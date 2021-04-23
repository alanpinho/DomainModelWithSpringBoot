package com.devsuperior.domain.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.domain.entities.Order;
import com.devsuperior.domain.repositories.OrderRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/orders")
@AllArgsConstructor
public class OrderController {

	private OrderRepository repository;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
}