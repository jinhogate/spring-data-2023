package com.jinhogate.sourcededonnees;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jinhogate.sourcededonnees.frameworktest.MyBean;
import com.jinhogate.sourcededonnees.model.Product;
import com.jinhogate.sourcededonnees.service.ProductService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@SpringBootApplication
public class SourcededonneesApplication implements CommandLineRunner {
	
	private Logger log = Logger.getLogger(SourcededonneesApplication.class.getName());
	
	private MyBean myBean;
	
	private ProductService productService;
	
	public SourcededonneesApplication(MyBean myBean, ProductService productService) {
		this.myBean = myBean;
		this.productService = productService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SourcededonneesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("I'am running!");
		log.info("le mot de passe   ------------> " + myBean.getPassWord());
		
		// Read product data
		log.info("Read all products");
		this.productService.getProducts().forEach(product -> log.info(product.getProductId() + "-" + product.getName() + "-" + product.getCost()));
		
		log.info("TRIER PAR NOM");
		this.productService.getProductsSortByNameAsc().forEach(product -> log.info(product.getProductId() + "-" + product.getName() + "-" + product.getCost()));
		
		log.info("Read one product by Id");
		Product product = this.productService.getOneProductById(1).orElse(null);
		log.log(Level.INFO, "La description du produit {0}", product);
		log.info("Read one product by Id With exception atending");
		Product productNotExiste = this.productService.getOneProductById(6).orElse(null);
		log.log(Level.INFO, "La description du produit {0}", productNotExiste);
		
		log.info("Le nombre total de produits dans la base");
		log.log(Level.INFO, "Le nombre de produits = {0}", this.productService.countAllProduct());
		
		log.info("Le produit existe ? ");
		String message = Boolean.TRUE.equals(this.productService.verifyExistence(2))? "Le produit existe ! " : "Produit non identifié!";
		log.info(message);
		
	}

}
