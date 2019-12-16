package com.netcraker.dragun.controllers;

import com.netcraker.dragun.model.Product;
import com.netcraker.dragun.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Product get(@PathVariable(name = "id") Long id) {
        return productService.get(id);
    }
    @GetMapping("/company/{id}")
    public List<Product> getProductCompany(@PathVariable(name ="id") Long id){
        return productService.getProductsCompany(id);
    }
    /*@GetMapping("/user/{id}")
    public List<Product> getProductUser(@PathVariable(name ="id") Long id){
        return productService.getProductsUser(id);
    }*/
    @PostMapping
    public Product create(@Valid @RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/{id}")
    public void create(@RequestBody Product product,
                       @PathVariable(name = "id") Long id) {
        productService.update(product, id);
    }

    @DeleteMapping("/{id}")
    public void create(@PathVariable(name = "id") Long id) {
        productService.delete(id);
    }
}
