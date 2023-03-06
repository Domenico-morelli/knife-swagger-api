package it.its.nttdata.demo.delegate.impl;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import it.its.nttdata.demo.delegate.UserApiDelegate;
import it.its.nttdata.demo.model.UserResponse;
import it.its.nttdata.demo.service.UserService;

@Component
public class UserApiDelegateImpl implements UserApiDelegate {

	private final static Log log = LogFactory.getLog(UserApiDelegateImpl.class);

	@Autowired
	UserService userService;

	public ResponseEntity<UserResponse> createUser(
			@ApiParam(value = "Created user object", required = true) @Valid @RequestBody UserResponse body) {
		log.info("POST /user/aggiungi/" + body + " - START");
		UserResponse response = userService.createUser(body);
		log.info("POST /user/aggiungi/" + body + " - FINE");
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	public ResponseEntity<List<UserResponse>> createUsersWithListInput(
			@ApiParam(value = "List of user object", required = true) @Valid @RequestBody List<UserResponse> body) {
		log.info("POST /user/createUsersWithListInput/" + body + " - START");
		List<UserResponse> response = userService.createUsersWithListInput(body);
		log.info("POST /user/createUsersWithListInput/" + body + " - FINE");
		return new ResponseEntity<List<UserResponse>>(response, HttpStatus.OK);
	}

	public ResponseEntity<String> deleteUser(
			@ApiParam(value = "The name that needs to be deleted", required = true) @RequestHeader(value = "username", required = true) String username) {
		log.info("DELETE /user/deleteUser/" + username + " - START");
		String response = userService.deleteUser(username);
		log.info("DELETE /user/deleteUser/" + username + " - FINE");
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	public ResponseEntity<UserResponse> getUserByName(
			@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @RequestHeader(value = "username", required = true) String username) {
		log.info("GET /user/getUserByName/" + username + " - START");
		UserResponse response = userService.getUserByName(username);
		log.info("GET /user/getUserByName/" + username + " - FINE");
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	public ResponseEntity<String> loginUser(
			@NotNull @ApiParam(value = "The user name for login", required = true) @Valid @RequestParam(value = "username", required = true) String username,
			@NotNull @ApiParam(value = "The password for login in clear text", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
		log.info("POST /user/loginUser/" + username + " - START");
		String response = userService.loginUser(username, password);
		log.info("POST /user/loginUser/" + username + " - FINE");
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	public ResponseEntity<UserResponse> logoutUser() {
		log.info("POST /user/logoutUser/ - START");
		UserResponse response = userService.logoutUser();
		log.info("POST /user/logoutUser/ - FINE");
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

	public ResponseEntity<UserResponse> updateUser(
			@ApiParam(value = "name that need to be updated", required = true) @RequestHeader(value = "username", required = true) String username,
			@ApiParam(value = "Updated user object", required = true) @Valid @RequestBody UserResponse body) {
		log.info("PUT /user/updateUser/" + username + "\n" + body + " - START");
		UserResponse response = userService.updateUser(username, body);
		log.info("PUT /user/updateUser/ " + username + "\n " + body + " - FINE");
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	}

}
