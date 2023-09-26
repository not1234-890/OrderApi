package com.orderAPI.service;

import com.orderAPI.controller.MockitoJUnitRunner;
import com.orderAPI.controller.RunWith;
import com.orderAPI.repository.OrderRepository;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

	@Mock
	OrderRepository orderRepository;
	
	OrderService orderService;
	
	@BeforeEach
	public void init() {
		this.orderService = new OrderService();
	}
	
	@Test 
	public void getAllOrders()
    {
        orderService.getAllOrders();
        verify(orderRepository).findAll();
    }
}
