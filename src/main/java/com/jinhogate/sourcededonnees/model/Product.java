package com.jinhogate.sourcededonnees.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "produit")
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produit_id")
	private Integer productId;
	
	@Column(name="nom")
	private String name;
	
	@Column(name="cout")
	private Integer cost;
	
	private String description;

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", cost=" + cost + ", description=" + description
				+ "]";
	}
	
	

}
