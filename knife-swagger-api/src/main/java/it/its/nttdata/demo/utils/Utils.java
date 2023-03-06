package it.its.nttdata.demo.utils;

import java.util.ArrayList;
import java.util.List;

import it.its.nttdata.demo.database.Knife;
import it.its.nttdata.demo.database.Order;
import it.its.nttdata.demo.database.User;
import it.its.nttdata.demo.model.KnifeResponse;
import it.its.nttdata.demo.model.KnifeResponse.StatusEnum;
import it.its.nttdata.demo.model.OrderResponse;
import it.its.nttdata.demo.model.UserResponse;

public class Utils {

	public static StatusEnum availabilityConversion(String availability) {
		StatusEnum response = null;
		switch (availability) {
		case "available":
			response = StatusEnum.AVAILABLE;
			break;
		case "pending":
			response = StatusEnum.PENDING;
			break;
		case "out of stock":
			response = StatusEnum.OUT_OF_STOCK;
			break;

		default:
			return null;
		}
		return response;
	}

	public static KnifeResponse conversion(Knife knife) throws NullPointerException {
		KnifeResponse kniferesponse = new KnifeResponse();
		kniferesponse.setId(knife.getId());
		kniferesponse.setName(knife.getName());
		kniferesponse.setPhotoUrls(knife.getPhotoUrls());
		kniferesponse.status(Utils.availabilityConversion(knife.getAvailability()));
		return kniferesponse;
	}

	public static Knife conversion(KnifeResponse kniferesponse) throws NullPointerException {
		Knife knife = new Knife();
		knife.setId(kniferesponse.getId());
		knife.setName(kniferesponse.getName());
		knife.setPhotoUrls(kniferesponse.getPhotoUrls());
		knife.setAvailability(kniferesponse.getStatus().toString());
		return knife;
	}

	public static User conversion(UserResponse userResponse) throws NullPointerException {
		User user = new User();
		user.setId(0);
		user.setName(userResponse.getFirstName());
		user.setSurname(userResponse.getLastName());
		user.setUsername(userResponse.getUsername());
		user.setPassword(userResponse.getPassword());
		user.setEmail(userResponse.getEmail());
		user.setPhone(userResponse.getPhone());
		user.setUserStatus(userResponse.getUserStatus());
		return user;
	}

	public static UserResponse conversion(User user) throws NullPointerException {
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setFirstName(user.getName());
		userResponse.setLastName(user.getSurname());
		userResponse.setUsername(user.getUsername());
		userResponse.setPassword(user.getPassword());
		userResponse.setEmail(user.getEmail());
		userResponse.setPhone(user.getPhone());
		userResponse.setUserStatus(user.getUserStatus());
		return userResponse;
	}

	public static OrderResponse conversion(Order order) throws NullPointerException {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setId(order.getId());
		orderResponse.setKnifeId(order.getKnifeId());
		orderResponse.setQuantity(order.getQuantity());
		orderResponse.setShipDate(order.getShipDate());
		orderResponse.setStatus(it.its.nttdata.demo.model.OrderResponse.StatusEnum.fromValue(order.getStatus()));
		orderResponse.setComplete(order.getComplete());
		return orderResponse;
	}

	public static Order conversion(OrderResponse orderResponse) throws NullPointerException {
		Order order = new Order();
		order.setId(orderResponse.getId());
		order.setKnifeId(orderResponse.getKnifeId());
		order.setQuantity(orderResponse.getQuantity());
		order.setShipDate(orderResponse.getShipDate());
		order.setStatus(orderResponse.getStatus().toString());
		order.setComplete(orderResponse.isComplete());
		return order;
	}

	/*
	 * 
	 * public static List<Knife> conversionKnifeResponseToKnife (List<KnifeResponse>
	 * knifeList) { List<Knife> knifeResponse = new ArrayList<>(); for
	 * (KnifeResponse knife : knifeList) {
	 * knifeResponse.add(Utils.conversion(knife)); } return knifeResponse; }
	 * 
	 * public static List<KnifeResponse> conversionKnifeToKnifeResponse (List<Knife>
	 * knifeList) { List<KnifeResponse> knifeResponse = new ArrayList<>(); for (
	 * Knife knife : knifeList) { knifeResponse.add(Utils.conversion(knife)); }
	 * return knifeResponse; }
	 */
}
