package it.its.nttdata.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import it.its.nttdata.demo.api.KnifeApiController;
import it.its.nttdata.demo.database.Knife;
import it.its.nttdata.demo.model.CategoryResponse;
import it.its.nttdata.demo.model.KnifeResponse;
import it.its.nttdata.demo.model.TagResponse;
import it.its.nttdata.demo.repositories.KnifeRepo;
import it.its.nttdata.demo.utils.Utils;
import it.its.nttdata.demo.model.KnifeResponse.StatusEnum;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(KnifeApiController.class)
class FirstJunitTest {

	// @InjectMocks private KnifeService service;

	@Mock
	private KnifeRepo knifeRepo;

	@Autowired
	private MockMvc mockMvc;

	long id = 231;
	List<String> photoList = new ArrayList<>();
	List<TagResponse> tags = new ArrayList<>();
	String js, js2, nullStr;
	Knife knife;
	KnifeResponse knifeResponse;
	KnifeResponse knifeResponse2;

	@BeforeEach
	void init() {
		photoList.add("photolistexample");
		tags.add(new TagResponse());
		knife = new Knife(id, "knifeName", photoList, StatusEnum.AVAILABLE.toString());
		knifeResponse = new KnifeResponse(id, new CategoryResponse(), "name1", photoList, tags, StatusEnum.AVAILABLE);
		knifeResponse2 = new KnifeResponse(id + 1, new CategoryResponse(), "name2", photoList, tags,
				StatusEnum.AVAILABLE);
		js = "{\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n" + "    \"name\": \"string\"\r\n" + "  },\r\n"
				+ "  \"id\": 0,\r\n" + "  \"name\": \"Kitemmm\",\r\n"
				+ "  \"photoUrls\": [\"https://m.media-amazon.com/images/I/71MF2V-4yPL._AC_SX679_.jpg\"],\r\n"
				+ "  \"status\": \"available\",\r\n" + "  \"tags\": [\r\n" + "    {\r\n" + "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ]\r\n" + "}";
		js2 = "{\r\n" + "  \"category\": {\r\n" + "    \"id\": 0,\r\n" + "    \"name\": \"string\"\r\n" + "  },\r\n"
				+ "  \"id\": 9000,\r\n" + "  \"name\": \"Victorinox Classic SD Swiss Army Knife\",\r\n"
				+ "  \"photoUrls\": [\"cose.jpg\"],\r\n" + "  \"status\": \"available\",\r\n" + "  \"tags\": [\r\n"
				+ "    {\r\n" + "      \"id\": 0,\r\n" + "      \"name\": \"string\"\r\n" + "    }\r\n" + "  ]\r\n"
				+ "}";
		nullStr = null;
	}

	// Junit jupiter tests

	@Test
	void shouldGetKnifeTest() throws Exception {
		mockMvc.perform(get("http://localhost:8080/v2/knife/knifeById").contentType(MediaType.APPLICATION_JSON)
				.header("knifeId", knifeResponse.getId())).andExpect(status().isOk());
	}

	@Test
	void shouldGetKnifeByStatusTest() throws Exception {
		mockMvc.perform(get("http://localhost:8080/v2/knife/findByStatus?status=available")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void shouldPostKnife() throws Exception {
		mockMvc.perform(
				post("http://localhost:8080/v2/knife/addKnife").contentType(MediaType.APPLICATION_JSON).content(js))
				.andExpect(status().isOk());
	}

	//TO DO EXCEPTION TESTING ON ALL
	@Test
	@Disabled
	public void shouldPostKnifeException() throws Exception {
		Exception exception = assertThrows(NullPointerException.class, () -> {
			mockMvc.perform(post("http://localhost:8080/v2/knife/addKnife").contentType(MediaType.APPLICATION_JSON)
					.content(js));
		});
	    assertEquals("smt",exception.getMessage());

	}

	@Test
	void shouldDeleteKnifeTest() throws Exception {
		mockMvc.perform(delete("http://localhost:8080/v2/knife/deleteKnife").contentType(MediaType.APPLICATION_JSON)
				.header("knifeId", knifeResponse.getId()));
	}

	@Test
	void shouldPutKnifeTest() throws Exception {
		mockMvc.perform(put("http://localhost:8080/v2/knife/updateKnife").contentType(MediaType.APPLICATION_JSON)
				.content(js2).header("knifeId", knifeResponse.getId()))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

}
