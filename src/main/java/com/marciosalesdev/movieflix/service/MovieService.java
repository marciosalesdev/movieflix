package com.marciosalesdev.movieflix.service;

import com.marciosalesdev.movieflix.entity.Category;
import com.marciosalesdev.movieflix.entity.Movie;
import com.marciosalesdev.movieflix.entity.Streaming;
import com.marciosalesdev.movieflix.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public MovieService(MovieRepository movieRepository, CategoryService categoryService, StreamingService streamingService) {
        this.movieRepository = movieRepository;
        this.categoryService = categoryService;
        this.streamingService = streamingService;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie save(Movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStriamings(movie.getStreamings()));
        return movieRepository.save(movie);
    }

    public Optional<Movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public void delebeById(Long id) {
        movieRepository.deleteById(id);
    }

    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category ->
                categoryService.findById(category.getId())
                        .ifPresent(categoriesFound::add)
        );
        return categoriesFound;
    }

    public List<Movie> findByCategory(Long category) {
        return movieRepository.findMovieByCategories(List.of(Category.builder().id(category).build()));
    }

    private List<Streaming> findStriamings(List<Streaming> streamings) {
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach(streaming ->
                streamingService.findById(streaming.getId())
                        .ifPresent(streamingsFound::add)
        );
        return streamingsFound;
    }

    public Optional<Movie> update(Long id, Movie movieUpdate) {
        Optional<Movie> optMovie = findById(id);
        if (optMovie.isPresent()) {
            List<Streaming> streamings = findStriamings(movieUpdate.getStreamings());
            List<Category> categories = findCategories(movieUpdate.getCategories());

            Movie movie = optMovie.get();
            movie.setTitle(movieUpdate.getTitle());
            movie.setDescription(movieUpdate.getDescription());
            movie.setReleaseDate(movieUpdate.getReleaseDate());
            movie.setRating(movieUpdate.getRating());

            movie.getCategories().clear();
            movie.getCategories().addAll(categories);
            movie.getStreamings().clear();
            movie.getStreamings().addAll(streamings);

            movieRepository.save(movie);
        }
        return Optional.empty();
    }
}
