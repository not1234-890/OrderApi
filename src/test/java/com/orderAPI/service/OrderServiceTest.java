package com.orderAPI.service;

import com.naceAPI.controller.MockitoJUnitRunner;
import com.naceAPI.controller.RunWith;
import com.naceAPI.repository.OrderRepository;

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
