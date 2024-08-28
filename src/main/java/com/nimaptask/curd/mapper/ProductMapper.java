package com.nimaptask.curd.mapper;

import com.nimaptask.curd.dto.ProductDto;
import com.nimaptask.curd.entity.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getPid(),
                product.getPname()
        );
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product(
                productDto.getPid(),
                productDto.getPname()
        );
    }
}
