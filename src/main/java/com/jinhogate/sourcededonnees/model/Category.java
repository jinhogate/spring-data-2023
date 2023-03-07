package com.jinhogate.sourcededonnees.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="categorie")
@Data
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categorie_id")
	private Integer categoryId;
	
	@Column(name="nom")
	private String name;
	
	@ManyToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
			)
	@JoinTable(
			name = "categorie_produit",
			joinColumns = @JoinColumn(name = "categorie_id"),
			inverseJoinColumns = @JoinColumn(name = "produit_id")
			)
	private List<Product> products = new ArrayList<>();

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + "]";
	}
	
	/**
	 * Méthode utilitaire pour ajouter un produit
	 * @param product
	 */
	 public void addProduct(Product product) {
		 this.products.add(product);
		 product.getCategories().add(this);
	 }
	 
	 /**
	  * Méthode utilitaire pour supprimer un produit de la relation bidirectionnelle
	  * @param product
	  */
	 public void removeProduct(Product product) {
		 this.products.remove(product);
		 product.getCategories().remove(this);
	 }

}
