package com.nimaptask.curd.repository;

import com.nimaptask.curd.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
