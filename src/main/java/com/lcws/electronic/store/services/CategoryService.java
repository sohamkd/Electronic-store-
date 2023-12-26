package com.lcws.electronic.store.services;

import com.lcws.electronic.store.dtos.CategoryDto;
import com.lcws.electronic.store.dtos.PageableResponse;

public interface CategoryService {

    //create

    CategoryDto create(CategoryDto categoryDto);

    //update
    CategoryDto update(CategoryDto categoryDto,String categoryId);

    //delete
    void delete(String categoryId);

    //get all

    PageableResponse<CategoryDto> getAll( int pageNumber,int pageSize,String sortBy,String sortDir);

    //get single category detail
    CategoryDto get(String categoryId);

    //search

}
