package com.altran.Academy.Controllers;

import com.altran.Academy.Repository.ProductRepository;
import com.altran.Academy.model.Product;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class productController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Product product){
        return ResponseEntity.ok(productRepository.save(product));
    }

    @GetMapping ( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProduct(){
        return ResponseEntity.ok(productRepository.findAll());
    }



}
