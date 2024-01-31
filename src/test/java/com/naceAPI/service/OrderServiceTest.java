package com.naceAPI.service;

import com.naceAPI.controller.MockitoJUnitRunner;
import com.naceAPI.controller.RunWith;
import com.naceAPI.repository.NaceRepository;
import com.naceAPI.repository.OrderRepository;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

	@Mock
	NaceRepository naceRepository;
	
	NaceService naceService;
	
	@BeforeEach
	public void init() {
		this.naceService = new NaceService();
	}
	
	@Test 
	public void getAllOrders()
    {
		naceService.getAllDetails();
        verify(naceRepository).findAll();
    }
}
