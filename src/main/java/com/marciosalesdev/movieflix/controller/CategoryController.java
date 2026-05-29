package com.marciosalesdev.movieflix.controller;

import com.marciosalesdev.movieflix.entity.Category;
import com.marciosalesdev.movieflix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/movieflix/category")
@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public List<Category> listaCategory() {
        return categoryService.findAll();
    }
}

