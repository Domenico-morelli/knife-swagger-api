package it.its.nttdata.demo.delegate;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import it.its.nttdata.demo.model.KnifeResponse;

public interface KnifeApiDelegate {

	default ResponseEntity<KnifeResponse> addKnife(KnifeResponse body) {

		return new ResponseEntity<KnifeResponse>(HttpStatus.OK);
	}

	default  ResponseEntity<KnifeResponse> deleteKnife(Long knifeId, String apiKey) {

		return new ResponseEntity<KnifeResponse>(HttpStatus.OK);
	}

	default  ResponseEntity<List<KnifeResponse>> findKnivesByStatus(List<String> status) {

		return new ResponseEntity<List<KnifeResponse>>(HttpStatus.OK);
	}

	default  ResponseEntity<KnifeResponse> getKnifeById(Long knifeId) {

		return new ResponseEntity<KnifeResponse>(HttpStatus.OK);
	}

	default  ResponseEntity<KnifeResponse> updateKnife(Long KnifeId, KnifeResponse body) {

		return new ResponseEntity<KnifeResponse>(HttpStatus.OK);
	}
}
