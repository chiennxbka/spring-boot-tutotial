package com.example.springboottutorial.rest;

import com.example.springboottutorial.dao.ProductRepository;
import com.example.springboottutorial.model.Products;
import com.example.springboottutorial.payload.ProductPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getListProduct() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PostMapping("/products")
    public ResponseEntity<Void> save(@RequestBody ProductPayload payload) {
        System.out.println(payload);
        Products products = new Products(UUID.randomUUID().toString(), payload.getProductName(),
                payload.getProductLine(), payload.getProductScale(), payload.getProductVendor(),
                payload.getProductDescription(), payload.getQuantityInStock(), payload.getBuyPrice(),
                payload.getMsrp(), payload.getProductImageLink());
        productRepository.save(products);
        return ResponseEntity.ok().build();
    }
}
