package com.nimaptask.curd.service.impl;

import com.nimaptask.curd.dto.CategoryDto;
import com.nimaptask.curd.entity.Category;
import com.nimaptask.curd.exception.ResourceNotFoundException;
import com.nimaptask.curd.mapper.CategoryMapper;
import com.nimaptask.curd.repository.CategoryRepository;
import com.nimaptask.curd.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category is Not Exists With given id: "+ categoryId));

        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((category)-> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto updatedCategory) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () ->new ResourceNotFoundException("Category is Not exists with given id: "+ categoryId)
        );

        category.setName(updatedCategory.getName());

        Category updatedCategoryObj = categoryRepository.save(category);

        return CategoryMapper.mapToCategoryDto(updatedCategoryObj);
    }

    @Override
    public void deleteCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () ->new ResourceNotFoundException("Category is Not exists with given id: "+ categoryId)
        );

        categoryRepository.deleteById(categoryId);
    }
}
