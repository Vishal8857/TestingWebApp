package com.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.product.Entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
