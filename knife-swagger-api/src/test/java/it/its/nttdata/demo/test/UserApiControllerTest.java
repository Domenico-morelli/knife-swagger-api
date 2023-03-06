package it.its.nttdata.demo.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.its.nttdata.demo.api.UserApiController;
import it.its.nttdata.demo.database.User;
import it.its.nttdata.demo.model.UserResponse;
import it.its.nttdata.demo.repositories.UserRepo;
import it.its.nttdata.demo.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserApiController.class)
class UserApiControllerTest {

	@InjectMocks
	UserServiceImpl serviceImpl;

	@Mock
	UserRepo repo;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private MockMvc mockMvc;
	
	User user;
	UserResponse userResponse;
	String js, js2;
	List<String> jsList;

	@BeforeAll
	static void beforeall() {
	}

	@BeforeEach
	void beforeEach() {
		user = new User((long) 1, "firstname1", "lastname1", "username1", "email@gmail.com1", "password1", "123456789",
				2);
		userResponse = new UserResponse((long) 1, "username", "firstname", "lastname", "email@gmail.com", "password",
				"123456789", 1);
		js = "{\r\n" + "  \"email\": \"giovanni.rana@gmail.com\",\r\n" + "  \"firstName\": \"Giovanni\",\r\n"
				+ "  \"id\": 0,\r\n" + "  \"lastName\": \"Rana\",\r\n" + "  \"password\": \"password\",\r\n"
				+ "  \"phone\": \"123456789\",\r\n" + "  \"userStatus\": 1,\r\n" + "  \"username\": \"Gianni-Rana\"\r\n"
				+ "}";
		js2 = "{\r\n" + "  \"email\": \"giovanni.rana@gmail.com\",\r\n" + "  \"firstName\": \"Giovanni\",\r\n"
				+ "  \"id\": 0,\r\n" + "  \"lastName\": \"Rana\",\r\n" + "  \"password\": \"password\",\r\n"
				+ "  \"phone\": \"123456789\",\r\n" + "  \"userStatus\": 1,\r\n" + "  \"username\": \"Gianni-Rana\"\r\n"
				+ "}";
		jsList = new ArrayList<String>(Arrays.asList(js, js2));
	}

	@Test
	@DisplayName("POST")
	void testCreateUser() throws Exception {

		mockMvc.perform(post("http://localhost:8080/v2/user").contentType(MediaType.APPLICATION_JSON).content(js))
				.andExpect(status().isOk());
	}
//TO SEE
	@Test
	@DisplayName("POST ARRAY")
	@Disabled
	void testCreateUsersWithListInput() throws Exception {
//		mockMvc.perform(
//				post("http://localhost:8080/v2/user/createWithList").contentType(MediaType.APPLICATION_JSON).content(jsList))
//				.andExpect(status().isOk());

	}

	@Test
	@DisplayName("DELETE")
	void testDeleteUser() throws Exception {
		mockMvc.perform(delete("http://localhost:8080/v2/user/deleteUserByName").contentType(MediaType.APPLICATION_JSON)
				.header("username", userResponse.getUsername())).andExpect(status().isOk());
	}

	@Test
	@DisplayName("GET")
	void testGetUserByName() throws Exception {
		when(repo.getUserByUsername("Ciccio")).thenReturn(user);
		UserResponse res = serviceImpl.getUserByName("Ciccio");
		assertEquals("username1", res.getUsername());

	}

	@DisplayName("PUT")
	@Test
	void testUpdateUser() throws Exception {
		mockMvc.perform(put("http://localhost:8080/v2/user/updateUserById").contentType(MediaType.APPLICATION_JSON).content(js)
				.header("username", userResponse.getUsername())).andExpect(status().isOk());
	}

}
