package com.naceAPI.controller;

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

import com.naceAPI.model.Nace;
import com.naceAPI.model.Orders;
import com.naceAPI.service.BeforeEach;
import com.naceAPI.service.NaceService;
import com.naceAPI.service.OrderService;
import com.naceDetails.util.OrderStatus;

@WebMvcTest
@RunWith(MockitoJUnitRunner.class)
public class NaCEControllerTest {
	@Mock
	NaceService naceService;
	@MockBean
	Nace nace;
	@Mock
	Nace nace1;
	NaceController naceController;

	@BeforeEach
	public void init() {
		this.naceController = new NaceController();
	}

	@Test
	void testGetNaceDetails() {
		ArrayList<Nace> naceList = new ArrayList<>();
		nace.setOrder(123);
		nace.setCode("A");
		nace.setLevel(1);
		nace.setDescription("for animals fund");
		
		naceList.add(nace);

		// when - action or the behaviour that we are going test
		ResultActions response = mockMvc.perform(get("/order"));

		// then - verify the output
		response.andExpect(status().isOk());
	}
	
	

}
