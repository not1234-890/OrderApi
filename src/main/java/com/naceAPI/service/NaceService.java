package com.naceAPI.service;

import java.util.ArrayList;
import java.util.List;

import com.naceAPI.model.Orders;
import com.naceAPI.repository.NaceRepository;
import com.naceAPI.repository.OrderRepository;
import com.naceDetails.util.OrderStatus;

//defining the business logic
@Service
public class NaceService {
	@Autowired
	NaceRepository naceRepository;

	// getting all books record by using the method findaAll() of CrudRepository
	public List<Nace> getAllDetails() {
		List<Nace> details = new ArrayList<Nace>();
		naceRepository.findAll().forEach(o -> details.add(o));
		return details;
	}

	// getting a specific record by using the method findById() of
	// CrudRepository
	public Nace getOrdersById(int id) {
		return naceRepository.findById(id).get();
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Nace nace) {
		naceRepository.save(nace);
	}

	// deleting a specific record by using the method deleteById() of
	// CrudRepository
	public void close(int id) {
		naceRepository.deleteById(id);
	}

	
}