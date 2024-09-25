package com.nimaptask.curd.controller;

import com.nimaptask.curd.dto.ProductDto;
import com.nimaptask.curd.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;

    //Build Add Category REST API
    @PostMapping
    public ResponseEntity<ProductDto> createCategory(@RequestBody ProductDto productDto){
        ProductDto savedProduct = productService.createProduct(productDto);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Build Get Category REST API
    @GetMapping("{pid}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("pid") Long productId){
        ProductDto productDto = productService.getProductById(productId);
        return ResponseEntity.ok(productDto);
    }

    //Build Get All Category REST API
    @GetMapping
    public ResponseEntity<Page<ProductDto>> getAllProduct(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size)
    {
        Pageable pageable = PageRequest.of(page, size);
//        List<ProductDto> product = productService.getAllProduct();
        Page<ProductDto> productPage = productService.getAllProducts(pageable);
        return ResponseEntity.ok(productPage);
    }

    // Build Update Category REST API
    @PutMapping("{pid}")
    public  ResponseEntity<ProductDto> updateProduct(@PathVariable("pid") Long productId,
                                                       @RequestBody ProductDto updateProduct){
        ProductDto productDto = productService.updateProduct(productId,updateProduct);
        return ResponseEntity.ok(productDto);
    }

    // Build Delete Category REST API
    @DeleteMapping("{pid}")
    public ResponseEntity<String> deleteProduct(@PathVariable("pid") Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Category Deleted Successfully!.");
    }
}
