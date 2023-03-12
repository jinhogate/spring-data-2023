package com.jinhogate.sourcededonnees.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jinhogate.sourcededonnees.model.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{
	
	public Optional<Product> findByName(String productName);
	
	public List<Product> findByNameOrCost(String productName, Integer productCost);
	
	public List<Product> findByNameContaining(String keyWordProductName);
	
	public List<Product> findByCategoriesCategoryId(Integer categoryId);
}
