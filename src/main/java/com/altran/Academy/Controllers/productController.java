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
    private
    ProductRepository productRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Product product){
        return ResponseEntity.ok(productRepository.save(product));
    }

    @GetMapping(params = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProductById(@PathVariable int id) {
        return ResponseEntity.ok(productRepository.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Product product){
        return ResponseEntity.ok(productRepository.save(product));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity delete(@PathVariable int id){
        productRepository.deleteById(id);
        return ResponseEntity.ok("RIP");
    }
    }









