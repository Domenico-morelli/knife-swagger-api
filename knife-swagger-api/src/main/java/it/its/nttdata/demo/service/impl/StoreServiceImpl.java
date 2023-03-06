package it.its.nttdata.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.its.nttdata.demo.database.Order;
import it.its.nttdata.demo.model.OrderResponse;
import it.its.nttdata.demo.repositories.StoreRepo;
import it.its.nttdata.demo.service.StoreService;
import it.its.nttdata.demo.utils.Utils;

@Service

public class StoreServiceImpl implements StoreService {

	private static Logger log = LoggerFactory.getLogger(StoreServiceImpl.class);

	@Autowired
	StoreRepo storeRepo;

	@Override
	public void deleteOrder(Long orderId) {
		log.info("StoreService - deleteOrder - START");
		try {
			storeRepo.deleteById(orderId);
		} catch (IllegalArgumentException e) {
			log.info("StoreService - deleteOrder " + "IllegalArgumentException " + e);
		} catch (Exception e) {
			log.info("StoreService - deleteOrder " + "Exception " + e);
		}
		log.info("StoreService - deleteOrder - FINE");
	}

	@Override
	public Map<String, Integer> getInventory() {
		log.info("StoreService - getInventory - START");
		Map<String, Integer> responseMap = new HashMap<String, Integer>();
		

		try {
			
		} catch (Exception e) {
		}
	
		log.info("StoreService - getInventory - FINE");
		return responseMap;
	}

	@Override
	public OrderResponse getOrderById(Long orderId) {
		log.info("StoreService - getOrderById - START");
		Order order = new Order();
		try {
			order = storeRepo.getOne(orderId);
		} catch (EntityNotFoundException e) {
			log.info("StoreService - getOrderById " + "EntityNotFoundException " + e);
		} catch (Exception e) {
			log.info("StoreService - getOrderById " + "Exception " + e);
		}
		log.info("StoreService - getOrderById - FINE");
		return Utils.conversion(order);
	}

	@Override
	public OrderResponse placeOrder(OrderResponse body) {
		log.info("StoreService - placeOrder - START");
		Order order = new Order();
		try {
			order = storeRepo.save(Utils.conversion(body));
		} catch (IllegalArgumentException e) {
			log.info("StoreService - placeOrder " + "IllegalArgumentException " + e);
		} catch (Exception e) {
			log.info("StoreService - placeOrder " + "Exception " + e);
		}
		log.info("StoreService - placeOrder - FINE");
		return Utils.conversion(order);
	}

	@Override
	public ResponseEntity<OrderResponse> modifyOrder(Long orderId, OrderResponse body) {
		// TODO Auto-generated method stub
		return null;
	}

}
