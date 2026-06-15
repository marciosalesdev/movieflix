package com.marciosalesdev.movieflix.controller;

import com.marciosalesdev.movieflix.controller.request.MovieRequest;
import com.marciosalesdev.movieflix.controller.response.MovieResponse;
import com.marciosalesdev.movieflix.entity.Movie;
import com.marciosalesdev.movieflix.mapper.MovieMapper;
import com.marciosalesdev.movieflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toMovieResponse(movieService.save(MovieMapper.toMovie(request))));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponse>> listMovie() {
        return ResponseEntity.ok(movieService.findAll().stream().map(MovieMapper::toMovieResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {
        return movieService.findById(id).map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie))).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id,
                                                @RequestBody MovieRequest movieUpdate) {
        return movieService.update(id, MovieMapper.toMovie(movieUpdate)).map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category) {
        return ResponseEntity.ok(movieService.findByCategory(category)
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList());
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        Optional<Movie> optMovie = movieService.findById(id);
        if (optMovie.isPresent()) {
            movieService.delebeById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
