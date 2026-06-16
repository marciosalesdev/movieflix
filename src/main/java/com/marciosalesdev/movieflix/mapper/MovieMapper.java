package com.marciosalesdev.movieflix.mapper;

import com.marciosalesdev.movieflix.controller.request.MovieRequest;
import com.marciosalesdev.movieflix.controller.response.CategoryResponse;
import com.marciosalesdev.movieflix.controller.response.MovieResponse;
import com.marciosalesdev.movieflix.controller.response.StreamingResponse;
import com.marciosalesdev.movieflix.entity.Category;
import com.marciosalesdev.movieflix.entity.Movie;
import com.marciosalesdev.movieflix.entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request) {
        List<Category> categories = request.categories()
                .stream()
                .map(categoryId -> Category
                        .builder()
                .id(categoryId)
                .build())
                .toList();

        List<Streaming> streamings = request.streamings()
                .stream()
                .map(streamingId -> Streaming
                        .builder()
                .id(streamingId)
                .build())
                .toList();

        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .rating(request.rating())
                .releaseDate(request.releaseDate())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toMovieResponse(Movie movie) {
        List<CategoryResponse> list = movie.getCategories()
                .stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();

        List<StreamingResponse> streamingResponses = movie.getStreamings()
                .stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();


        return MovieResponse.builder()
                .id(movie.getId()).
                title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .categories(list)
                .streamings(streamingResponses)
                .build();
    }
}
