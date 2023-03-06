package it.its.nttdata.demo.api;

import java.util.List;

import it.its.nttdata.demo.delegate.UserApiDelegate;
import it.its.nttdata.demo.model.UserResponse;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-02-02T09:30:50.975Z")

@Controller
public class UserApiController implements UserApi {

	UserApiDelegate delegate;

	@Autowired
	public UserApiController(UserApiDelegate delegate) {
		this.delegate = delegate;
	}

	public ResponseEntity<UserResponse> createUser(
			@ApiParam(value = "Created user object", required = true) @Valid @RequestBody UserResponse body) {
		return delegate.createUser(body);
	}

	public ResponseEntity<List<UserResponse>> createUsersWithListInput(
			@ApiParam(value = "List of user object", required = true) @Valid @RequestBody List<UserResponse> body) {
		return delegate.createUsersWithListInput(body);
	}

	public ResponseEntity<String> deleteUser(
			@ApiParam(value = "The name that needs to be deleted", required = true) @RequestHeader(value = "username", required = true) String username) {
		return delegate.deleteUser(username);
	}

	public ResponseEntity<UserResponse> getUserByName(
			@ApiParam(value = "The name that needs to be fetched. Use user1 for testing. ", required = true) @RequestHeader(value = "username", required = true) String username) {
		return delegate.getUserByName(username);
	}

	public ResponseEntity<String> loginUser(
			@NotNull @ApiParam(value = "The user name for login", required = true) @Valid @RequestParam(value = "username", required = true) String username,
			@NotNull @ApiParam(value = "The password for login in clear text", required = true) @Valid @RequestParam(value = "password", required = true) String password) {

		return delegate.loginUser(username, password);
	}

	public ResponseEntity<UserResponse> logoutUser() {

		return delegate.logoutUser();
	}

	public ResponseEntity<UserResponse> updateUser(
			@ApiParam(value = "name that need to be updated", required = true) @RequestHeader(value = "username", required = true) String username,
			@ApiParam(value = "Updated user object", required = true) @Valid @RequestBody UserResponse body) {

		return delegate.updateUser(username, body);
	}

}
