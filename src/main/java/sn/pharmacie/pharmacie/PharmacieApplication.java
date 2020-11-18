package sn.pharmacie.pharmacie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import sn.pharmacie.pharmacie.entities.Pharmacie;
import sn.pharmacie.pharmacie.repository.PharmacieRepository;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
@ComponentScan(basePackages= {"sn.pharmacie.repository"})

public class PharmacieApplication implements CommandLineRunner{

@Autowired
private PharmacieRepository pharmacieRepo;



	public static void main(String[] args) {
		SpringApplication.run(PharmacieApplication.class, args);	
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
	Pharmacie pharmacie = new Pharmacie();
	pharmacie.setNom("GUIGUON");
	pharmacie.setVille("DAKAR");
	pharmacie.setQuartier("	Malika");
	pharmacie.setEtat(2);
	
	
	pharmacieRepo.save(pharmacie);
	
	pharmacieRepo.findAll().forEach(p -> System.out.println(p.getVille()));
	
	
		
	}
	

	

}
