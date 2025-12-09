package com.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{
	
}
