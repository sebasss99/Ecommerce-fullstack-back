package com.sebastianmatallana.ecommerce.backend.infrastructure.rest;

import com.sebastianmatallana.ecommerce.backend.application.ProductService;
import com.sebastianmatallana.ecommerce.backend.domain.model.Category;
import com.sebastianmatallana.ecommerce.backend.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//http://localhost:8080
@RequestMapping("/api/v1/admin/products")
//http://localhost:8080/api/v1/admin/products
@Slf4j
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        
        return new ResponseEntity<>(this.productService.save(product), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(this.productService.findAll());
    }

    //http://localhost:8080/api/v1/admin/products/id
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById (@PathVariable Integer id) {
        return ResponseEntity.ok(this.productService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById (@PathVariable Integer id) {
        this.productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
