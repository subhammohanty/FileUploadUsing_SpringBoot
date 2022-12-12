package com.spring.patch.api.controller;

import com.spring.patch.api.entity.Product;
import com.spring.patch.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id , @RequestBody Product product){
        return productService.updateProduct(id , product);
    }

    @PatchMapping("/{id}")
    public Product updateUsingPatch(@PathVariable int id , @RequestBody Map<String, Object> fields){
        return productService.updateUsingPatch(id , fields);
    }
}
