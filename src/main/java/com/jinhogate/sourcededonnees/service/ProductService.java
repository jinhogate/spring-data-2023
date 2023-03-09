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
	
	public Product addProduct(Product product) {
		return this.productRepository.save(product);
	}

}
