package it.its.nttdata.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.its.nttdata.demo.model.KnifeResponse;
import it.its.nttdata.demo.model.ModelApiResponse;

@Service
public interface KnifeService {

	KnifeResponse addKnife(KnifeResponse body);

	KnifeResponse deleteKnife(Long knifeId);

	List<KnifeResponse> findKnivesByStatus(List<String> status);

	KnifeResponse getKnifeById(Long knifeId);

	KnifeResponse updateKnife(Long knifeId, KnifeResponse body);

	KnifeResponse updatwKnifetWithForm(Long postKnifeBytId, String name, String status);

	ResponseEntity<ModelApiResponse> uploadFile(Long postKnifeBytId, String Metadata, MultipartFile file);

}
