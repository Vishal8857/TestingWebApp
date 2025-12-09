package com.product.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.product.Entity.Product;
import com.product.Repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo produtRepo;
	
	
	
	public Product createProduct(Product product) {
		
		return produtRepo.save(product);
	}
	
	public List<Product> allProduct(){
		List<Product> productList=produtRepo.findAll();
		
		return productList;
	}
	
    public Optional<Product> findById(Long id) {
        return produtRepo.findById(id);
    }
}
