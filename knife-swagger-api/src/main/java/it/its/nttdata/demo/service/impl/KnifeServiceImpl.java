package it.its.nttdata.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.its.nttdata.demo.database.Knife;
import it.its.nttdata.demo.model.KnifeResponse;
import it.its.nttdata.demo.model.ModelApiResponse;
import it.its.nttdata.demo.repositories.KnifeRepo;
import it.its.nttdata.demo.service.KnifeService;
import it.its.nttdata.demo.utils.Utils;

@Service
public class KnifeServiceImpl implements KnifeService {

	@Autowired
	KnifeRepo knifeRepo;

	private static Logger log = LoggerFactory.getLogger(KnifeServiceImpl.class);

	@Override
	public KnifeResponse getKnifeById(Long knifeId) {
		log.debug("KnifeService - getKnifeById - START");
		Knife knife = new Knife();
		KnifeResponse response = new KnifeResponse();
		knife = knifeRepo.getKnifeById(knifeId);
		// try {
		response = Utils.conversion(knife);
		log.debug("KnifeService - getKnifeById - FINE");
		return response;
//		} catch (NullPointerException e) {
		// to-do add response error message
		// }
//		return response;
	}

	@Override
	public KnifeResponse addKnife(KnifeResponse body) {
		log.debug("KnifeService - addKnife - START");
		KnifeResponse knifeResponse = null;
		try {
			Knife response = Utils.conversion(body);
			;
			// System.out.println(response.toString());
			response = knifeRepo.save(response);
			// System.out.println(response.toString());
			knifeResponse = Utils.conversion(response);
			log.debug("KnifeService - addKnife - FINE");
			return knifeResponse;
		} catch (NullPointerException e) {
			// to-do add response error message
		} catch (Exception e) {
			log.debug("KnifeService - addKnife " + "Exception " + e);
		}
		return knifeResponse;
	}

	@Override
	public KnifeResponse deleteKnife(Long knifeId) {
		log.debug("KnifeService - deleteKnife - START");

		KnifeResponse response = new KnifeResponse();
		try {
			response = Utils.conversion(knifeRepo.getKnifeById(knifeId));
			knifeRepo.deleteById(knifeId);
		} catch (EntityNotFoundException e) {
			log.debug("KnifeService - deleteKnife " + "EntityNotFoundException " + e);
		} catch (IllegalArgumentException e) {
			log.debug("KnifeService - deleteKnife " + "IllegalArgumentException " + e);
		} catch (Exception e) {
			log.debug("KnifeService - deleteKnife " + "Exception " + e);
		}
		log.debug("KnifeService - deleteKnife - FINE");
		return response;
	}

	@Override
	public List<KnifeResponse> findKnivesByStatus(List<String> status) {
		log.debug("KnifeService - findKnivesByStatus - START");
		List<Knife> knifeList = knifeRepo.findAll();
		List<KnifeResponse> responseList = new ArrayList<KnifeResponse>();
		if (!knifeList.isEmpty()) {
			// filter the list using the status list
			Predicate<Knife> knifePredicate = (item) -> (status.contains(item.getAvailability()));

			for (Knife knife : knifeList) {
				if (knifePredicate.test(knife)) {
					responseList.add(Utils.conversion(knife));
					log.debug("Knife added to response list: " + knife);
				}
			}
		}
		log.debug("KnifeService - findKnivesByStatus - FINE");
		return responseList;
	}

	@Override
	public KnifeResponse updateKnife(Long knifeId, KnifeResponse body) {
		log.debug("KnifeService - updateKnife - START");
		Knife res = null;
		try {
			knifeRepo.deleteById(knifeId);
			res = knifeRepo.save(Utils.conversion(body));
			return Utils.conversion(res);
		} catch (EntityNotFoundException e) {
			log.debug("KnifeService - updateKnife " + "EntityNotFoundException " + e);
		} catch (IllegalArgumentException e) {
			log.debug("KnifeService - updateKnife " + "IllegalArgumentException " + e);
		} catch (Exception e) {
			log.debug("KnifeService - updateKnife " + "Exception " + e);
		}
		log.debug("KnifeService - updateKnife - FINE");
		return Utils.conversion(res);
	}

	@Override
	public KnifeResponse updatwKnifetWithForm(Long postKnifeBytId, String name, String status) {

		return null;
	}

	@Override
	public ResponseEntity<ModelApiResponse> uploadFile(Long postKnifeBytId, String Metadata, MultipartFile file) {

		return null;
	}

}
