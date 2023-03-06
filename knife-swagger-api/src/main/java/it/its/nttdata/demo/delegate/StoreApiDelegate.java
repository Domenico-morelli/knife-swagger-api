package it.its.nttdata.demo.delegate;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import it.its.nttdata.demo.model.OrderResponse;

public interface StoreApiDelegate {

	default ResponseEntity<Void> deleteOrder(Long orderId) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	default ResponseEntity<Map<String, Integer>> getInventory() {
		return new ResponseEntity<Map<String, Integer>>(HttpStatus.OK);
	}

	default ResponseEntity<OrderResponse> getOrderById(Long orderId) {
		return new ResponseEntity<OrderResponse>(HttpStatus.OK);
	}

	default ResponseEntity<OrderResponse> placeOrder(OrderResponse body) {
		return new ResponseEntity<OrderResponse>(HttpStatus.OK);
	}

}
