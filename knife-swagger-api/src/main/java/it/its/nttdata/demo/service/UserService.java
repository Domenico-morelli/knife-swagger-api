package it.its.nttdata.demo.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.its.nttdata.demo.model.UserResponse;

@Service
public interface UserService {

	UserResponse createUser(UserResponse body);

	List<UserResponse> createUsersWithListInput(List<UserResponse> body);

	String deleteUser(String username);

	UserResponse getUserByName(String username);

	String loginUser(String userId, String password);

	UserResponse logoutUser();

	UserResponse updateUser(String userId, UserResponse body);

}
