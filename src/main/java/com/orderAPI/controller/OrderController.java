package com.orderAPI.controller;

import java.net.URI;
import java.util.List;

import com.orderAPI.model.Orders;
import com.orderAPI.service.OrderService;
import com.orderAPI.util.OrderType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//mark class as Controller
@RestController
public class OrderController {
	// autowire the BooksService class
	@Autowired
	OrderService orderService;

	// creating a get mapping that retrieves all the books detail from the
	// database
	@GetMapping("/order")
	private List<Orders> getAllOrders() {
		return orderService.getAllOrders();
	}

	// creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/order/{orderId}")
	private Orders getOrders(@PathVariable("orderId") int orderId) {
		return orderService.getOrderById(orderId);
	}

	// creating a delete mapping that deletes a specified book
	@DeleteMapping("/book/{bookid}")
	private void closeOrder(@PathVariable("orderId") int orderId) {
		orderService.close(orderId);
	}

	// creating post mapping that post the book detail in the database
	@PostMapping("/order")
	private int saveOrder(@RequestBody Orders order) {
		orderService.saveOrUpdate(order);
		return order.getOrderid();
	}

	// creating put mapping that updates the book detail
	@PutMapping("/order")
	private ResponseEntity update(@RequestBody Orders order) {

		Orders savedOrder = orderService.saveOrUpdate(order);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedOrder.getOrderid()).toUri();

		return ResponseEntity.created(location).body(
				 "Order was successfully saved.");
	}
}
