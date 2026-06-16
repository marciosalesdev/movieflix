package com.marciosalesdev.movieflix.controller;

import com.marciosalesdev.movieflix.controller.request.CategoryRequest;
import com.marciosalesdev.movieflix.controller.response.CategoryResponse;
import com.marciosalesdev.movieflix.entity.Category;
import com.marciosalesdev.movieflix.mapper.CategoryMapper;
import com.marciosalesdev.movieflix.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/movieflix/category")
@RestController
@RequiredArgsConstructor
@Tag(name = "Categoria", description = "Recurso responsavel pelo gerenciamento a categoria dos filmes")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public ResponseEntity<List<CategoryResponse>> listCategory() {
        return ResponseEntity.ok(categoryService.findAll()
                .stream()
                .map(
                        category ->
                                CategoryMapper.toCategoryResponse(category))
                .toList());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> saveCategory(@Valid  @RequestBody CategoryRequest category) {
        Category category1 = CategoryMapper.toCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(categoryService.saveCategory(category1)));

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
        return categoryService.findById(id).map(category ->
                ResponseEntity.ok(CategoryMapper.toCategoryResponse(category))).orElse(
                ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.delebeById(id);
    }
}
