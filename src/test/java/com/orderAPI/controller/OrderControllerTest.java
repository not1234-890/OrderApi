package com.orderAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import com.naceAPI.model.Orders;
import com.naceAPI.service.BeforeEach;
import com.naceAPI.service.OrderService;
import com.naceDetails.util.OrderStatus;

@WebMvcTest
@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	@Mock
	OrderService orderService;
	@MockBean
	Orders orders;
	@Mock
	Orders orders1;
	OrderController orderController;

	@BeforeEach
	public void init() {
		this.orderController = new OrderController();
	}

	@Test
	void testGetOrders() {
		ArrayList<Orders> orderList = new ArrayList<>();
		orders.setOrderid(123);
		orders.setDate(new Date());
		orders.setOrderName("iPhone");
		orders.setPrice(50000);
		orders.setStatus(OrderStatus.OPEN);
		orderList.add(orders);
		orders1.setOrderid(124);
		orders1.setDate(new Date());
		orders1.setOrderName("Nokia");
		orders1.setPrice(30000);
		orders1.setStatus(OrderStatus.OPEN);
		orderList.add(orders1);

		// when - action or the behaviour that we are going test
		ResultActions response = mockMvc.perform(get("/order"));

		// then - verify the output
		response.andExpect(status().isOk());
	}
	
	@Test
	void testUpdate() {
		long employeeId = 1L;
		orders.setOrderid(123);
		orders.setDate(new Date());
		orders.setOrderName("iPhone");
		orders.setPrice(50000);
		orders.setStatus(OrderStatus.OPEN);

		orders.setOrderid(123);
		orders.setDate(new Date());
		orders.setOrderName("iPhone");
		orders.setPrice(60000);
		orders.setStatus(OrderStatus.OPEN);
		
        given(orderService.getOrdersById(123)).willReturn(Optional.of(orders));
        given(orderService.update(orders,123))
                .willAnswer((invocation)-> invocation.getArgument(0));

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(put("/order")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(objectMapper.writeValueAsString(orders)));


        // then - verify the output
        response.andExpect(status().isOk());
		
	}

}
