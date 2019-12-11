package com.netcracker.dragun.repository;

import com.netcracker.dragun.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findProductByCompanyId(Long id);
}
