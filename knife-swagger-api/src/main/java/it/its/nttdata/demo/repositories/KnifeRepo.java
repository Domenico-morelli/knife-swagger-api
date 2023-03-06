package it.its.nttdata.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import it.its.nttdata.demo.database.Knife;

@Repository
public interface KnifeRepo extends JpaRepository<Knife, Long> {

	@Query(value = "SELECT distinct k.*, knife_photourls.k_photos \r\n"
			+ "FROM \r\n"
			+ "public.knife  \r\n"
			+ "k\r\n"
			+ "JOIN knife_photourls ON k.k_id = knife_photourls.knife_k_id\r\n"
			+ "WHERE\r\n"
			+ "k_id = :knifeId", nativeQuery = true)
	Knife getKnifeById(Long knifeId);

}
