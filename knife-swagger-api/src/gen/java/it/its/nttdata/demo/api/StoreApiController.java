package it.its.nttdata.demo.api;

import java.util.Map;

import it.its.nttdata.demo.delegate.StoreApiDelegate;
import it.its.nttdata.demo.model.OrderResponse;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-02-02T09:30:50.975Z")

@Controller
public class StoreApiController implements StoreApi {

	StoreApiDelegate delegate;

	@Autowired
	public StoreApiController(StoreApiDelegate delegate) {
		super();
		this.delegate = delegate;
	}

	public ResponseEntity<Void> deleteOrder(
			@ApiParam(value = "ID of the order that needs to be deleted", required = true) @RequestHeader(value = "orderId", required = true) Long orderId) {
		return delegate.deleteOrder(orderId);
	}

	public ResponseEntity<Map<String, Integer>> getInventory() {
		return delegate.getInventory();
	}
	public ResponseEntity<OrderResponse> getOrderById(
			@ApiParam(value = "ID of knife that needs to be fetched", required = true) @RequestHeader(value = "orderId", required = true) Long orderId) {
		return delegate.getOrderById(orderId);
	}
	public ResponseEntity<OrderResponse> placeOrder(
			@ApiParam(value = "order placed for purchasing the Knife", required = true) @Valid @RequestBody OrderResponse body) {
		return delegate.placeOrder(body);
	}

}
