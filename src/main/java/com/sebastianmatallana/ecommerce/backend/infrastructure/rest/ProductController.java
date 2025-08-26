package com.sebastianmatallana.ecommerce.backend.infrastructure.rest;

import com.sebastianmatallana.ecommerce.backend.application.ProductService;
import com.sebastianmatallana.ecommerce.backend.domain.model.Category;
import com.sebastianmatallana.ecommerce.backend.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
//http://localhost:8080
@RequestMapping("/api/v1/admin/products")
//http://localhost:8080/api/v1/admin/products
@Slf4j
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> save(@RequestParam("id") Integer id,
                                        @RequestParam("code") String code,
                                        @RequestParam("name") String name,
                                        @RequestParam("description") String description,
                                        @RequestParam("price")BigDecimal price,
                                        @RequestParam("urlImage")String urlImage,
                                        @RequestParam("userId")Integer userId,
                                        @RequestParam("categoryId")Integer categoryId) {
        Product product = new Product();
        if (id != null && id > 0) {
            product.setId(id);
        }
        product.setCode(code);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategoryId(categoryId);
        product.setUserId(userId);
        product.setUrlImage(urlImage);



        log.info("Nombre producto {}", product.getName());
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
