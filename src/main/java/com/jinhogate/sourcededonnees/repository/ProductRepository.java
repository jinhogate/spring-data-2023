package com.jinhogate.sourcededonnees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jinhogate.sourcededonnees.model.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{
}
