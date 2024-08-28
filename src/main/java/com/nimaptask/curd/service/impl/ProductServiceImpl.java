package com.nimaptask.curd.service.impl;

import com.nimaptask.curd.dto.ProductDto;
import com.nimaptask.curd.entity.Product;
import com.nimaptask.curd.exception.ResourceNotFoundException;
import com.nimaptask.curd.mapper.ProductMapper;
import com.nimaptask.curd.repository.ProductRepository;
import com.nimaptask.curd.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product is Not Exists With given id: "+ productId));

        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().map((product)-> ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProduct) {
        Product product = productRepository.findById(productId).orElseThrow(
                () ->new ResourceNotFoundException("Product is Not exists with given id: "+ productId)
        );

        product.setPname(updatedProduct.getPname());

        Product updatedProductObj = productRepository.save(product);

        return ProductMapper.mapToProductDto(updatedProductObj);
    }

    @Override
    public void deleteProduct(Long productId) {

        Product product = productRepository.findById(productId).orElseThrow(
                () ->new ResourceNotFoundException("Product is Not exists with given id: "+ productId)
        );

        productRepository.deleteById(productId);
    }

}
