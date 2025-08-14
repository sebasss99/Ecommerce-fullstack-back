package com.sebastianmatallana.ecommerce.backend.infrastructure.rest;

import com.sebastianmatallana.ecommerce.backend.application.CategoryService;
import com.sebastianmatallana.ecommerce.backend.domain.model.Category;
import com.sebastianmatallana.ecommerce.backend.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//http://localhost:8080
@RequestMapping("/api/v1/admin/categories")
//http://localhost:8080/api/v1/admin/categories
@Slf4j
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return new ResponseEntity<>(this.categoryService.save(category), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Category>> findAll() {
        return ResponseEntity.ok(this.categoryService.findAll());
    }

    //http://localhost:8080/api/v1/admin/categories/id
    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById (@PathVariable Integer id) {
        return ResponseEntity.ok(this.categoryService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCategoryById (@PathVariable Integer id) {
        this.categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
