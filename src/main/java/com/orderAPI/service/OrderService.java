package com.orderAPI.service;

import java.util.ArrayList;
import java.util.List;

import com.orderAPI.model.Orders;
import com.orderAPI.repository.OrderRepository;
import com.orderAPI.util.OrderStatus;

//defining the business logic
@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;

	// getting all books record by using the method findaAll() of CrudRepository
	public List<Orders> getAllOrders() {
		List<Orders> orders = new ArrayList<Orders>();
		orderRepository.findAll().forEach(o -> orders.add(o));
		return orders;
	}

	// getting a specific record by using the method findById() of
	// CrudRepository
	public Orders getOrdersById(int id) {
		return orderRepository.findById(id).get();
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Orders order) {
			orderRepository.save(order);
	}

	// deleting a specific record by using the method deleteById() of
	// CrudRepository
	public void close(int id) {
		orderRepository.deleteById(id);
	}

	// updating a record
	public void update(Orders order, int orderId) {
		if(!OrderStatus.CLOSE.name().equalsIgnoreCase(order.getStatus().name())) {
			orderRepository.save(order);
		}
	}
}