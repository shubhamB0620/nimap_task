package com.nimaptask.curd.service;

import com.nimaptask.curd.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Long productId);

    List<ProductDto> getAllProduct();

    ProductDto updateProduct(Long pid, ProductDto updatedProduct);

    void deleteProduct(Long productId);

}
