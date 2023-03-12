package com.jinhogate.sourcededonnees.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jinhogate.sourcededonnees.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	@Query(value = "select * from categorie where nom like %?1%", nativeQuery = true)
	public List<Category> findByNameContain(String keyWordNameCategoery);
	
	@Modifying
	@Query(value = "update categorie set nom = ?1 where categorie_id = ?2", nativeQuery = true)
	public void updateCategory(String categoryName, Integer categoryId);

}
