package it.its.nttdata.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.its.nttdata.demo.database.User;
import it.its.nttdata.demo.model.UserResponse;
import it.its.nttdata.demo.repositories.UserRepo;
import it.its.nttdata.demo.service.UserService;
import it.its.nttdata.demo.utils.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserResponse createUser(UserResponse body) {
		log.info("UserService - createUser - START");
		User user = new User();
		
		try {
			// add validation for username
			user = userRepo.save(Utils.conversion(body));
		} catch (IllegalArgumentException e) {
			log.info("UserService - createUser " + "IllegalArgumentException " + e);
		} catch (Exception e) {
			log.info("UserService - createUser " + "Exception " + e);
		}
		log.info("UserService - createUser - FINE");
		return Utils.conversion(user);
	}

	@Override
	public List<UserResponse> createUsersWithListInput(List<UserResponse> userListToAdd) {
		log.info("UserService - Lista user da addare - START");

		List<UserResponse> userResponseList = new ArrayList<UserResponse>();
		try {
			// add validation for username
			if (!userListToAdd.isEmpty()) {
				for (UserResponse user : userListToAdd) {
					userRepo.save(Utils.conversion(user));
				}
//				userResponseList = userRepo.returnAddedUsersList(userListToAdd);
			}
		} catch (IllegalArgumentException e) {
			log.info("UserService - Lista user da addare " + "IllegalArgumentException " + e);
		} catch (Exception e) {
			log.info("UserService - Lista user da addare " + "Exception " + e);
		}
		log.info("UserService - Lista user da addare - FINE");
		return userResponseList;
	}

	@Override
	public String deleteUser(String username) {
		log.info("UserService - deleteUser - START");
		String response = "Error with deleting user with username: " + username;
		try {
			userRepo.deleteUserbyUsername(username);
			response = "User with username: " + username + " has been deleted succesfully";
		} catch (EntityNotFoundException e) {
			log.info("UserService - deleteUser " + "EntityNotFoundException " + e);
		} catch (IllegalArgumentException e) {
			log.info("UserService - deleteUser " + "IllegalArgumentException " + e);
		} catch (Exception e) {
			log.info("UserService - deleteUser " + "Exception " + e);
		}
		log.info("UserService - deleteUser - FINE");
		return response;
	}

	@Override
	public UserResponse getUserByName(String username) {
		log.info("UserService - getUserByName - START");
		User user = new User();
		UserResponse response = new UserResponse();
		try {
			user = userRepo.getUserByUsername(username);
			response = Utils.conversion(user);
		} catch (EntityNotFoundException e) {
			log.info("UserService - getUserByName " + "EntityNotFoundException " + e);
		} catch (Exception e) {
			log.info("UserService - getUserByName " + "Exception " + e + "user: " + user);
		}
		log.info("UserService - getUserByName - FINE");
		return response;
	}

	@Override
	public String loginUser(String userId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse logoutUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse updateUser(String username, UserResponse body) {
		log.info("UserService - updateUser - START");
		User user = new User();
		try {
			userRepo.updateUserByUsername(username, body.getFirstName(), body.getLastName(), body.getUsername(),
					body.getEmail(), body.getPassword(), body.getPhone(), body.getUserStatus());
			log.info("-------------------------------------------------------------------------------------------");

				user = userRepo.getUserByUsername(username);
			

		} catch (EntityNotFoundException e) {
			log.info("UserService - updateUser " + "EntityNotFoundException " + e);
		} catch (Exception e) {
			log.info("UserService - updateUser " + "Exception " + e + "user: " + user);
		}
		log.info("UserService - updateUser - FINE");
		return Utils.conversion(user);
	}

}
