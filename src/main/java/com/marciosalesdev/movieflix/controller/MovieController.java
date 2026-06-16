package com.marciosalesdev.movieflix.controller;

import com.marciosalesdev.movieflix.controller.request.MovieRequest;
import com.marciosalesdev.movieflix.controller.response.MovieResponse;
import com.marciosalesdev.movieflix.entity.Movie;
import com.marciosalesdev.movieflix.mapper.MovieMapper;
import com.marciosalesdev.movieflix.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/movieflix/movie")
@RequiredArgsConstructor
@Tag(name = "Movie", description = "Recurso responsavel pelo gerenciamento dos filmes")
public class MovieController {

    private final MovieService movieService;

    @Operation(summary = "salvar filmes", description = "metodo para salvar filmes")
    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso.",
            content = @Content(schema = @Schema(implementation = MovieResponse.class)))
    @PostMapping
    public ResponseEntity<MovieResponse> save(@Valid @RequestBody MovieRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toMovieResponse(movieService.save(MovieMapper.toMovie(request))));
    }

    @Operation(summary = "Lista de filmes", description = "recurso de buscar lista de filmes")
    @GetMapping
    public ResponseEntity<List<MovieResponse>> listMovie() {
        return ResponseEntity.ok(movieService.findAll().stream().map(MovieMapper::toMovieResponse).toList());
    }

    @Operation(summary = "Busca filme por id.", description = "recurso de buscar filme por id correspondente")
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {
        return movieService.findById(id).map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie))).orElse(ResponseEntity.notFound().build());
    }
    @Operation(summary = "Atualizar filme", description = "recurso de buscar atualizar filme.")
    @PutMapping("/{id}")
    public ResponseEntity<MovieResponse> update(@PathVariable Long id, @Valid
    @RequestBody MovieRequest movieUpdate) {
        return movieService.update(id, MovieMapper.toMovie(movieUpdate)).map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());

    }
    @Operation(summary = "Buscar lista de filme por categoria", description = "Recurso de buscar atualizar filme.")
    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long category) {
        return ResponseEntity.ok(movieService.findByCategory(category)
                .stream()
                .map(MovieMapper::toMovieResponse)
                .toList());
    }
    @Operation(summary = "delete filme por id", description = "recurso de deletar filme.")
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
