package com.naceAPI.controller;

import java.net.URI;
import java.util.List;

import com.naceAPI.model.Nace;
import com.naceAPI.model.Orders;
import com.naceAPI.service.NaceService;
import com.naceAPI.service.OrderService;
import com.naceDetails.util.OrderType;

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
public class NaceController {
	// autowire the BooksService class
	@Autowired
	NaceService naceService;

	// creating a get mapping that retrieves all the nace detail from the
	// database
	@GetMapping("/read")
	private List<Nace> getAllDetails() {
		return naceService.getAllDetails();
	}

	@GetMapping("/nace/{orderId}")
	private Nace getNace(@PathVariable("naceId") int orderId) {
		return naceService.getNaceById(orderId);
	}

	@DeleteMapping("/nace/{orderid}")
	private void closeOrder(@PathVariable("orderId") int orderId) {
		naceService.close(orderId);
	}

	@PostMapping("/nace")
	private int saveOrder(@RequestBody Nace nace) {
		naceService.saveOrUpdate(nace);
		return nace.getOrder();
	}

	// creating put mapping that updates the nace detail
	@PutMapping("/nace")
	private ResponseEntity update(@RequestBody Nace nace) {

		Nace savedNace = naceService.saveOrUpdate(nace);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{orderId}").buildAndExpand(savedNace.getOrder()).toUri();

		return ResponseEntity.created(location).body(
				"Nace was successfully saved.");
	}
}
