package com.jinhogate.sourcededonnees.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@DynamicInsert
@DynamicUpdate
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
	
	@OneToMany(
			mappedBy = "product"
			)
	private List<Comment> comments = new ArrayList<>();
	
	@ManyToMany(
			mappedBy = "products",
			cascade = CascadeType.ALL
			)
	private List<Category> categories = new ArrayList<>();

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", cost=" + cost + ", description=" + description + "]";
	}
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
		comment.setProduct(this);
	}
	
	public void removeComment(Comment comment) {
		this.comments.remove(comment);
		comment.setProduct(null);
	}

}
