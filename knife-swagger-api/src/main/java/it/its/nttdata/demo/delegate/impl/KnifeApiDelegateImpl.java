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
import it.its.nttdata.demo.delegate.KnifeApiDelegate;
import it.its.nttdata.demo.model.KnifeResponse;
import it.its.nttdata.demo.service.KnifeService;

@Component
public class KnifeApiDelegateImpl  implements KnifeApiDelegate{

    private final static Log log = LogFactory.getLog(KnifeApiDelegateImpl.class);

    @Autowired
	private  KnifeService knifeService;
	
	public ResponseEntity<KnifeResponse> addKnife(
			@ApiParam(value = "Knife object that needs to be added to the store", required = true) @Valid @RequestBody KnifeResponse body) {
		log.info("POST /coltello/aggiungi/" + " - START");
		KnifeResponse response = knifeService.addKnife(body);
		log.info("POST /coltello/aggiungi/" + " - FINE");
		return new ResponseEntity<KnifeResponse>(response, HttpStatus.OK);
	}
	

	public ResponseEntity<KnifeResponse> deleteKnife(
			@ApiParam(value = "Knife id to delete", required = true) @RequestHeader(value = "knifeId", required = true) Long knifeId,
			@ApiParam(value = "") @RequestHeader(value = "api_key", required = false) String apiKey) {
		log.info("DELETE /coltello/cancella/" + knifeId + " - START");
		KnifeResponse response = knifeService.deleteKnife(knifeId);
		log.info("DELETE /coltello/cancella/" + knifeId + " - FINE");
		return new ResponseEntity<KnifeResponse>(response,HttpStatus.OK);
	}

	public ResponseEntity<List<KnifeResponse>> findKnivesByStatus(
			@NotNull @ApiParam(value = "Status values that need to be considered for filter", required = true, allowableValues = "available, pending, not in stock") @Valid @RequestParam(value = "status", required = true) List<String> status) {
		log.info("GET /coltello/findKnivesByStatus/" + status.toString() + " - START");
		List<KnifeResponse> response = knifeService.findKnivesByStatus(status);
		log.info("GET /coltello/findKnivesByStatus/" + status.toString() + " - FINE");
		return new ResponseEntity<List<KnifeResponse>>(response,HttpStatus.OK);
	}

	public ResponseEntity<KnifeResponse> getKnifeById(
			@ApiParam(value = "ID of knife that needs to be fetched", required = true) @RequestHeader(value = "knifeId", required = true) Long knifeId) {
		log.info("GET /coltello/getKnifeById/" + "ID: " + knifeId + " - START");
		KnifeResponse response = knifeService.getKnifeById(knifeId);
		log.info("GET /coltello/getKnifeById/" + "ID: " + knifeId + " - FINE");
		return new ResponseEntity<KnifeResponse>(response, HttpStatus.OK);
	}

	public ResponseEntity<KnifeResponse> updateKnife(
			@ApiParam(value = "Knife object that needs to be added to the store", required = true) Long KnifeId ,@Valid @RequestBody KnifeResponse body) {
		log.info("UPDATE /coltello/modifica/" + body + " - START");
		KnifeResponse response = knifeService.updateKnife(KnifeId,body);
		log.info("UPDATE /coltello/modifica/" + body + " - FINE");
		return new ResponseEntity<KnifeResponse>(response,HttpStatus.OK);
	}
}
