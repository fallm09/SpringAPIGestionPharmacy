package sn.pharmacie.pharmacie.repository;


import org.springframework.stereotype.Repository;


import sn.pharmacie.pharmacie.entities.Pharmacie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository 
public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer>{

	
	@Query("select p from Pharmacie p where p.quartier = :quartier")
	public List<Pharmacie> getAllPharmacieByQuartier(@Param("quartier")String quartier);
	@Query("select p from  Pharmacie p where p.ville = :ville")
	public List<Pharmacie> getAllPharmacieByVille(@Param("ville")String ville);
	@Query("select p from  Pharmacie p where p.id = :id")
	public Pharmacie getById(@Param("id")int id);



	
	
	

}
