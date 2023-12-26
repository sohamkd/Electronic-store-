package com.lcws.electronic.store.controllers;

import com.lcws.electronic.store.dtos.ApiResponseMessage;
import com.lcws.electronic.store.dtos.CategoryDto;
import com.lcws.electronic.store.dtos.PageableResponse;
import com.lcws.electronic.store.dtos.UserDto;
import com.lcws.electronic.store.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
    {
        CategoryDto categoryDto1 = categoryService.create(categoryDto);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }


    //update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
                                                       @PathVariable String categoryId)
    {
        CategoryDto updatedCategory = categoryService.update(categoryDto, categoryId);
        return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponseMessage> deleteCategory(@PathVariable String categoryId)
    {
        categoryService.delete(categoryId);

        ApiResponseMessage message = ApiResponseMessage.builder().message("User is deleted successfully!!").success(true).status(HttpStatus.OK).build();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping
     public ResponseEntity<PageableResponse<CategoryDto>> getAll(
             @RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
             @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
             @RequestParam(value = "sortBy",defaultValue = "name",required = false) String sortBy,
             @RequestParam(value = "sortDir",defaultValue = "asc",required = false) String sortDir
    )
     {
         return new ResponseEntity<>(categoryService.getAll(pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);

     }


     @GetMapping("/{categoryId}")
     public ResponseEntity<CategoryDto> getSingle(@PathVariable String categoryId)
     {
         CategoryDto categoryDto = categoryService.get(categoryId);
         return ResponseEntity.ok(categoryDto);
     }
}
