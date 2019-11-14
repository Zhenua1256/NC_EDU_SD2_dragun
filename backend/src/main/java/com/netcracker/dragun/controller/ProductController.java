package com.netcracker.dragun.controller;

import com.netcracker.dragun.entity.Product;
import com.netcracker.dragun.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {
    private  final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }
    @PostMapping
    public Product createSubscription (@RequestBody Product product){
        return productService.save(product);
    }
    @GetMapping(value = "/{id}")
    public Product get (@PathVariable(name = "id")Long id ){
        return productService.get(id);
    }
}
