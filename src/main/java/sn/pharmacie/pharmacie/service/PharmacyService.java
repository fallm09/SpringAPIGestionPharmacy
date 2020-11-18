package sn.pharmacie.pharmacie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sn.pharmacie.pharmacie.entities.Pharmacie;
import sn.pharmacie.pharmacie.repository.PharmacieRepository;

@RestController
public class PharmacyService {
	@Autowired
	private PharmacieRepository pharmacieRepo;
	
	@RequestMapping(value = "pharmacies/pharmacie" , method = RequestMethod.GET)
	public  List <Pharmacie> getAll()  {
		return pharmacieRepo.findAll();	
	}
	
	@RequestMapping(value = "/pharmacie/pharmacie/{ville}" ,method = RequestMethod.GET)
	public  List <Pharmacie> getAllPharmacieByVille(@PathVariable String ville){
		return pharmacieRepo.getAllPharmacieByVille(ville);	

	}
	@RequestMapping(value = "/pharmacie/pharmacie/{quartier}" ,method = RequestMethod.GET)
	public  List <Pharmacie> getAllPharmacieByQuartier(@PathVariable String quartier)
	{
		return pharmacieRepo. getAllPharmacieByQuartier(quartier);	

	}
	@RequestMapping(value = "/pharmacie/pharmacie/save" ,method = RequestMethod.POST)
	public  List <Pharmacie>save (Pharmacie pharmacie){
		pharmacieRepo.save(pharmacie);
		return pharmacieRepo.findAll();

	}
	@RequestMapping(value = "/pharmacie/pharmacie/delete/{id}" ,method = RequestMethod.DELETE)
	public  List <Pharmacie>delete (@PathVariable int id)
	{
		if(pharmacieRepo.getById(id) != null) {
			pharmacieRepo.delete(pharmacieRepo.getById(id));
			
		}
		return pharmacieRepo.findAll();	

	}
	@RequestMapping(value = "/pharmacie/pharmacie/get" ,method = RequestMethod.GET)
	public  Pharmacie get (@RequestParam int id)
	{
		return pharmacieRepo.getById(id);	

	}
	@RequestMapping(value = "/pharmacie/pharmacie/update/{id}" ,method = RequestMethod.PUT )
	public  List <Pharmacie> update (@PathVariable int id, Pharmacie pharmacie)
	{
		pharmacie.setId(id);
		pharmacie.save(pharmacie);
		return pharmacieRepo.findAll();	
	

	}


	

	


	



	


}
