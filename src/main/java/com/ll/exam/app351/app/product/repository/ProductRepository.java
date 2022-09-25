package com.ll.exam.app351.app.product.repository;


import com.ll.exam.app351.app.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
