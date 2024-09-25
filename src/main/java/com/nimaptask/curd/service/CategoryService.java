package com.nimaptask.curd.service;

import com.nimaptask.curd.dto.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long categoryId);

    List<CategoryDto> getAllCategory();

    Page<CategoryDto> getAllCategories(Pageable pageable);

    CategoryDto updateCategory(Long id, CategoryDto updatedCategory);

    void deleteCategory(Long categoryId);

}
