package com.nimaptask.curd.service;

import com.nimaptask.curd.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long categoryId);

    List<CategoryDto> getAllCategory();

    CategoryDto updateCategory(Long id, CategoryDto updatedCategory);

    void deleteCategory(Long categoryId);
}
