package it.its.nttdata.demo.api;

import it.its.nttdata.demo.delegate.KnifeApiDelegate;
import it.its.nttdata.demo.model.KnifeResponse;
import it.its.nttdata.demo.model.ModelApiResponse;
import it.its.nttdata.demo.service.KnifeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2023-02-02T09:30:50.975Z")

@Controller
public class KnifeApiController implements KnifeApi {

	private final KnifeApiDelegate knifeApiDelegate;

	@Autowired
	public KnifeApiController(KnifeApiDelegate knifeApiDelegate) {
		this.knifeApiDelegate = knifeApiDelegate;

	}

	public ResponseEntity<KnifeResponse> addKnife(
			@ApiParam(value = "Knife object that needs to be added to the store", required = true) @Valid @RequestBody KnifeResponse body) {

		return knifeApiDelegate.addKnife(body);
	}

	public ResponseEntity<KnifeResponse> deleteKnife(
			@ApiParam(value = "Knife id to delete", required = true) @RequestHeader(value = "knifeId", required = true) Long knifeId,
			@ApiParam(value = "") @RequestHeader(value = "api_key", required = false) String apiKey) {

		return knifeApiDelegate.deleteKnife(knifeId, apiKey);
	}

	public ResponseEntity<List<KnifeResponse>> findKnivesByStatus(
			@NotNull @ApiParam(value = "Status values that need to be considered for filter", required = true, allowableValues = "available, pending, not in stock") @Valid @RequestParam(value = "status", required = true) List<String> status) {
		return knifeApiDelegate.findKnivesByStatus(status);
	}

	public ResponseEntity<KnifeResponse> getKnifeById(
			@ApiParam(value = "ID of knife that needs to be fetched", required = true) @RequestHeader(value = "knifeId", required = true) Long knifeId) {
		return knifeApiDelegate.getKnifeById(knifeId);
	}

	public ResponseEntity<KnifeResponse> updateKnife(
			@ApiParam(value = "Knife object that needs to be added to the store", required = true) Long KnifeId ,@Valid @RequestBody KnifeResponse body) {
		return knifeApiDelegate.updateKnife(KnifeId, body);
	}

	public ResponseEntity<KnifeResponse> updatwKnifetWithForm(
			@ApiParam(value = "ID of knife that needs to be updated", required = true) @RequestHeader(value = "postKnifeBytId", required = true) Long postKnifeBytId,
			@ApiParam(value = "Updated name of the knife") @RequestParam(value = "name", required = false) String name,
			@ApiParam(value = "Updated status of the knife") @RequestParam(value = "status", required = false) String status) {

		return new ResponseEntity<KnifeResponse>(HttpStatus.OK);
	}

	public ResponseEntity<ModelApiResponse> uploadFile(
			@ApiParam(value = "ID of knife to update", required = true) @RequestHeader(value = "knifeId", required = true) Long knifeId,
			@ApiParam(value = "Additional data to pass to server") @RequestParam(value = "additionalMetadata", required = false) String additionalMetadata,
			@ApiParam(value = "file to upload") @Valid @RequestPart(value = "file", required = false) MultipartFile file) {
		return new ResponseEntity<ModelApiResponse>(HttpStatus.OK);
	}

}
