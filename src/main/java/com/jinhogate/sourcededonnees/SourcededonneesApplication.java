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
import com.jinhogate.sourcededonnees.model.Category;
import com.jinhogate.sourcededonnees.model.Comment;
import com.jinhogate.sourcededonnees.model.Product;
import com.jinhogate.sourcededonnees.service.CategoryService;
import com.jinhogate.sourcededonnees.service.CommentService;
import com.jinhogate.sourcededonnees.service.ProductService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class SourcededonneesApplication implements CommandLineRunner {
	
	private Logger log = Logger.getLogger(SourcededonneesApplication.class.getName());
	
	private MyBean myBean;
	
	private ProductService productService;
	
	private CategoryService categoryService;
	
	private CommentService commentService;
	
	public SourcededonneesApplication(MyBean myBean,
															ProductService productService,
															CategoryService categoryService,
															CommentService commentService) {
		this.myBean = myBean;
		this.productService = productService;
		this.categoryService = categoryService;
		this.commentService = commentService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SourcededonneesApplication.class, args);
	}

	@Override
	@Transactional
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
		log.info("La liste des commentaires du produit (1)");
		log.log(Level.INFO, "Commentaire du produit(1) {0}", product.getComments());
		log.info("Read one product by Id With exception atending");
		Product productNotExiste = this.productService.getOneProductById(6).orElse(null);
		log.log(Level.INFO, "La description du produit {0}", productNotExiste);
		
		log.info("Le nombre total de produits dans la base");
		log.log(Level.INFO, "Le nombre de produits = {0}", this.productService.countAllProduct());
		
		log.info("Le produit existe ? ");
		String message = Boolean.TRUE.equals(this.productService.verifyExistence(2))? "Le produit existe ! " : "Produit non identifié!";
		log.info(message);
		
		log.info("Information sur la categorie");
		Category categoryObjet = this.categoryService.getOneCategoryById(1).orElse(null);
		
		if(categoryObjet!= null) {
			log.log(Level.INFO, "Les informations sur la categorie : {0}", categoryObjet);
			
			log.info("Information sur la categorie + produits");
			categoryObjet.getProducts().forEach(productElement -> log.log(Level.INFO, "Les produits de la catégorie : {0}", productElement));
		}
		
		log.info("Recuperer un produit et ses catégories");
		Product productFirst = this.productService.getOneProductById(1).orElse(null);
		if(productFirst != null) {
			log.log(Level.INFO, "La liste des catégories du produit (1) {0}",productFirst.getCategories());
		}
		
		log.info("Recupere un commentaire et son produit");
		Comment commentFirst = this.commentService.getOneCommentById(1).orElse(null);
		if(commentFirst != null) {
			log.log(Level.INFO, "La liste des produits du commentaire (1) {0}",commentFirst.getProduct().getName());
		}
		
		log.info("Création d'une nouvelle catégorie");
		Category newCategory = new Category();
		newCategory.setName("Promotion");
		
		// Persister la nouvelle catégorie
		newCategory = this.categoryService.addCategory(newCategory);
		log.log(Level.INFO, "La nouvelle catégorie : {0}", newCategory);
		
		log.info("Création d'un nouveau produit");
		Product newProduit = new Product();
		newProduit.setName("Assurance à vie");
		newProduit.setCost(15);
		newProduit.setDescription("Assurance à vie, garantie jusqu'au dernier souffle");
		
		newCategory.addProduct(newProduit);
		
		// Persister le nouveau produit
		newProduit  = this.productService.addProduct(newProduit);
		log.log(Level.INFO, "Le nouveau produit : {0}", newProduit);
		log.log(Level.INFO, "Les categories liées à ce produit : {0}", newProduit.getCategories());
		
	}

}
