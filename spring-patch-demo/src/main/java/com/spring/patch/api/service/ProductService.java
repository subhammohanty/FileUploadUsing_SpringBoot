package com.spring.patch.api.service;

import com.spring.patch.api.entity.Product;
import com.spring.patch.api.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public Product saveProduct(Product product) {
        if(Objects.nonNull(product)){
            return productRepo.save(product);
        }else{
            return null;
        }
    }

    public Product updateProduct(int id, Product product) {
        Optional<Product> productById = productRepo.findById(id);
        if(productById.isPresent()){
            productById.get().setName(product.getName());
            productById.get().setDescription(product.getDescription());
            productById.get().setPrice(product.getPrice());
        }
        return productRepo.save(productById.get());
    }

    public Product updateUsingPatch(int id, Map<String, Object> fields) {
        Optional<Product> existingProduct = productRepo.findById(id);
        if(existingProduct.isPresent()){
            fields.forEach((key , value) ->{
                Field field = ReflectionUtils.findField(Product.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field , existingProduct.get() , value);
            });
            return productRepo.save(existingProduct.get());
        }
            return null;
    }
}
