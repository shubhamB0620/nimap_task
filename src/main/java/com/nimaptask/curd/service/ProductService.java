package com.nimaptask.curd.service;

import com.nimaptask.curd.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long productId);

    List<ProductDto> getAllProduct();

    Page<ProductDto> getAllProducts(Pageable pageable);

    ProductDto updateProduct(Long pid, ProductDto updatedProduct);

    void deleteProduct(Long productId);
}
