package com.netcracker.dragun.service;

import com.netcracker.dragun.entity.Product;
import com.netcracker.dragun.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product get(Long id) {
        return productRepository.findById(id).get();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
    public List<Product> getProductsCompany(Long companyId){
        return productRepository.findProductByCompanyId(companyId);
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
