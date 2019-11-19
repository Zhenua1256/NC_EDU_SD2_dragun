package com.netcraker.dragun.service;

import com.netcraker.dragun.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    private RestTemplate restTemplate;
    @Value("${backend.url}")
    private String backendURL;

    public ProductService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public Product get(Long id) {
        return restTemplate.getForObject(backendURL + "products/" + id, Product.class);
    }

    public List<Product> getAll() {
        return Arrays.asList(restTemplate.getForObject(backendURL + "products", Product[].class));
    }

    public Product create(Product product) {
        return restTemplate.postForObject(backendURL + "products", product, Product.class);
    }

    public void update(Product product, Long id) {
        restTemplate.put(backendURL + "products/" + id, product);
    }

    public void delete(Long id) {
        restTemplate.delete(backendURL + "products/" + id);
    }
}
