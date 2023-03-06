package it.its.nttdata.demo.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import it.its.nttdata.demo.api.StoreApiController;
import it.its.nttdata.demo.database.Order;
import it.its.nttdata.demo.model.OrderResponse;
import it.its.nttdata.demo.model.OrderResponse.StatusEnum;
import it.its.nttdata.demo.repositories.StoreRepo;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(StoreApiController.class)
class StoreApiTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	StoreRepo repo;
	
	@InjectMocks
	StoreApiController controller;
	
	Order order;
	OrderResponse response;
	String OrderJs;
	long id;
	long knifeId;

	@BeforeEach
	void beforeEach() {
		id = 282;
		knifeId = 34;
		order = new Order(id, knifeId, 2, new Date(2020, 4, 10), "delivered", false);
		response = new OrderResponse(id, knifeId, 3, new Date(2020, 4, 10), StatusEnum.APPROVED, true);
		OrderJs = "{\r\n" + "  \"complete\": false,\r\n" + "  \"id\": 0,\r\n" + "  \"knifeId\": 0,\r\n"
				+ "  \"quantity\": 0,\r\n" + "  \"shipDate\": \"2023-02-28T14:18:43.712Z\",\r\n"
				+ "  \"status\": \"placed\"\r\n" + "}";
	}

	@Test
	@DisplayName("DELETE")
	void testDeleteOrder() throws Exception {
		mockMvc.perform(delete("http://localhost:8080/v2/store/deleteOrderById").contentType(MediaType.APPLICATION_JSON)
				.header("orderId", order.getId())).andExpect(status().isOk());
	}

	@Test
	@Disabled
	@DisplayName("GET_INVENTORY")
	void testGetInventory() throws Exception {
		fail("Not yet implemented");
	}

	//TO DO QUERY (NO SESSION ERROR)
	@Test
	@Disabled
	@DisplayName("GET")
	void testGetOrderById() throws Exception {
		//when(repo.getOne(order.getId())).thenReturn(order);
		mockMvc.perform(get("http://localhost:8080/v2/store/getOrderById").contentType(MediaType.APPLICATION_JSON)
				.header("orderId", order.getId())).andExpect(status().isOk());
	}

	@Test
	@DisplayName("POST")
	void testPlaceOrder() throws Exception {
		mockMvc.perform(
				post("http://localhost:8080/v2/store/order").contentType(MediaType.APPLICATION_JSON).content(OrderJs))
				.andExpect(status().isOk());
	}

}
