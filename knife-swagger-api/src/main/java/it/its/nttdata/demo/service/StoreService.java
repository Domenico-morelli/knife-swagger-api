package it.its.nttdata.demo.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.its.nttdata.demo.model.OrderResponse;

@Service
public interface StoreService {

	void deleteOrder(Long orderId);

	Map<String, Integer> getInventory();

	OrderResponse getOrderById(Long orderId);

	OrderResponse placeOrder(OrderResponse body);

	ResponseEntity<OrderResponse> modifyOrder(Long orderId, OrderResponse body);

}
