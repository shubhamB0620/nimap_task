package com.nimaptask.curd.controller;

import com.nimaptask.curd.dto.CategoryDto;
import com.nimaptask.curd.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;

    //Build Add Category REST API
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto savedCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    // Build Get Category REST API
    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId){
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    //Build Get All Category REST API
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> category = categoryService.getAllCategory();
        return ResponseEntity.ok(category);
    }

    // Build Update Category REST API
    @PutMapping("{id}")
    public  ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId,
                                                       @RequestBody CategoryDto updateCategory){
        CategoryDto categoryDto = categoryService.updateCategory(categoryId,updateCategory);
        return ResponseEntity.ok(categoryDto);
    }

    // Build Delete Category REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category Deleted Successfully!.");
    }
}
