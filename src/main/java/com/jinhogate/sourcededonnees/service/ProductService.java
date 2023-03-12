package com.jinhogate.sourcededonnees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jinhogate.sourcededonnees.model.Product;
import com.jinhogate.sourcededonnees.repository.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepository;
	
	public ProductService (ProductRepository productRepo) {
		this.productRepository = productRepo;
	}
	
	public List<Product> getProducts() {
		return this.productRepository.findAll();
	}
	
	public List<Product> getProductsSortByNameAsc() {
		return this.productRepository.findAll(Sort.by(Direction.ASC, "name"));
	}
	
	public Optional<Product> getOneProductById(Integer id) {
		return this.productRepository.findById(id);
	}
	
	public Long countAllProduct() {
		return this.productRepository.count();
	}
	
	public Boolean verifyExistence(Integer id) {
		return this.productRepository.existsById(id);
	}
	
	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	public void deleteProduct(Integer id) {
		this.productRepository.deleteById(id);
	}
	
	public Optional<Product> getProductByName(String productName){
		return this.productRepository.findByName(productName);
	}
	
	public List<Product> getProductsByNameOrCost(String productName, Integer productCost){
		return this.productRepository.findByNameOrCost(productName, productCost);
	}
	
	public List<Product> getProductByNameContaining(String keyWordProductName){
		return this.productRepository.findByNameContaining(keyWordProductName);
	}
	
	public List<Product> getProductsByCategoriesId(Integer categoryId){
		return this.productRepository.findByCategoriesCategoryId(categoryId);
	}

}
