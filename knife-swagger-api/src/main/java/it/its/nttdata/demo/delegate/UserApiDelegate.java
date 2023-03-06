package it.its.nttdata.demo.delegate;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import it.its.nttdata.demo.model.UserResponse;

public interface UserApiDelegate {

	default ResponseEntity<UserResponse> createUser(UserResponse body) {
		return new ResponseEntity<UserResponse>(HttpStatus.OK);
	}

	default ResponseEntity<UserResponse> createUsersWithArrayInput(List<UserResponse> body) {
		return new ResponseEntity<UserResponse>(HttpStatus.OK);
	}

	default ResponseEntity<List<UserResponse>> createUsersWithListInput(List<UserResponse> body) {
		return new ResponseEntity<List<UserResponse>>(HttpStatus.OK);
	}

	default ResponseEntity<String> deleteUser(String username) {
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	default ResponseEntity<UserResponse> getUserByName(String username) {
		return new ResponseEntity<UserResponse>(HttpStatus.OK);
	}

	default ResponseEntity<String> loginUser(String userId,String password) {
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	default ResponseEntity<UserResponse> logoutUser() {
		return new ResponseEntity<UserResponse>(HttpStatus.OK);
	}

	default ResponseEntity<UserResponse> updateUser(String userId,UserResponse body) {
		return new ResponseEntity<UserResponse>(HttpStatus.OK);
	}

}
