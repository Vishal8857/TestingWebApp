package com.product.Controller;

import com.product.CommanClasses.UserResponse;
import com.product.Entity.Category;
import com.product.Service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createCategory(@RequestBody Category category) {

        if (category.getName() == null || category.getName().trim().isEmpty()) {
            throw new RuntimeException("Category name is required.");
        }

        Category savedCategory = service.createCategory(category);
        UserResponse response = new UserResponse("Category added successfully...", savedCategory.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/allCategory")
    public List<Category> allCategory() {
        return service.allCategory();
    }
}
