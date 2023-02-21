package com.jinhogate.sourcededonnees.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jinhogate.sourcededonnees.model.Category;
import com.jinhogate.sourcededonnees.repository.CategoryRepository;

@Service
public class CategoryService {
	
	private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public Optional<Category> getOneCategoryById(Integer id) {
		return this.categoryRepository.findById(id);
	}

}
