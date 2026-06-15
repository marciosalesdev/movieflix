package com.marciosalesdev.movieflix.service;

import com.marciosalesdev.movieflix.entity.Category;
import com.marciosalesdev.movieflix.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private CategoryRepository categoryRepository;


    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    @Transactional
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }


    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Transactional
    public void delebeById(Long id) {
        categoryRepository.deleteById(id);
    }
}
