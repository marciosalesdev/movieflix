package com.marciosalesdev.movieflix.repository;

import com.marciosalesdev.movieflix.entity.Category;
import com.marciosalesdev.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> id(Long id);

    List<Movie> findMovieByCategories(List<Category> categories);

}
