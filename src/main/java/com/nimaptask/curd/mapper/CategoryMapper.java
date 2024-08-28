package com.nimaptask.curd.mapper;

import com.nimaptask.curd.dto.CategoryDto;
import com.nimaptask.curd.entity.Category;

public class CategoryMapper {

    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }

    public static Category mapToCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.getId(),
                categoryDto.getName()
        );
    }
}
