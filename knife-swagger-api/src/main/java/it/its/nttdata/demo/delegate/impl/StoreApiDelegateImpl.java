package it.its.nttdata.demo.delegate.impl;

import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import io.swagger.annotations.ApiParam;
import it.its.nttdata.demo.delegate.StoreApiDelegate;
import it.its.nttdata.demo.model.OrderResponse;
import it.its.nttdata.demo.service.StoreService;

@Component
public class StoreApiDelegateImpl implements StoreApiDelegate {

	private final static Log log = LogFactory.getLog(UserApiDelegateImpl.class);

	@Autowired
	StoreService storeService;

	public ResponseEntity<Void> deleteOrder(
			@ApiParam(value = "ID of the order that needs to be deleted", required = true) @RequestHeader(value = "orderId", required = true) Long orderId) {
		log.info("DELETE /order/delete/" + orderId + " - START");
		storeService.deleteOrder(orderId);
		log.info("DELETE /order/delete/ - FINE");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	public ResponseEntity<Map<String, Integer>> getInventory() {
		log.info("GET /order/getInventory/" + " - START");
		Map<String, Integer> response = storeService.getInventory();
		log.info("GET /order/getInventory/ - FINE");
		return new ResponseEntity<Map<String, Integer>>(response, HttpStatus.OK);
	}

	public ResponseEntity<OrderResponse> getOrderById(
			@ApiParam(value = "ID of knife that needs to be fetched", required = true) @RequestHeader(value = "orderId", required = true) Long orderId) {
		log.info("GET /order/getOrderById/" + orderId + " - START");
		OrderResponse response = storeService.getOrderById(orderId);
		log.info("GET /order/getOrderById/  - FINE");
		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}

	public ResponseEntity<OrderResponse> placeOrder(
			@ApiParam(value = "order placed for purchasing the Knife", required = true) @Valid @RequestBody OrderResponse body) {
		log.info("POST /order/placeOrder/" + body + " - START");
		OrderResponse response = storeService.placeOrder(body);
		log.info("POST /order/placeOrder/ - FINE");
		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}

	// TO-DO
	public ResponseEntity<OrderResponse> modifyOrder(Long orderId, OrderResponse body) {
		log.info("PUT /order/modifyOrder/" + "orderId: " + orderId + " body: " + body + " - START");
		OrderResponse response = storeService.placeOrder(body);
		log.info("PUT /order/modifyOrder/ - FINE");
		return new ResponseEntity<OrderResponse>(response, HttpStatus.OK);
	}
}
