package com.marciosalesdev.movieflix.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(
        Long id,
        @Schema(type = "string",description = "Titulo do filme" )
        String title,
        @Schema(type = "string",description = "descriçao do filme" )
        String description,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @Schema(type = "date",description = "data de lançamento do filme ex: '19/09/2022'" )
        LocalDate releaseDate,
        @Schema(type = "double",description = "score do filme ex: '7.9'" )
        double rating,
        @Schema(type = "array",description = "lista de codigos de categoria" )
        List<CategoryResponse> categories,
        @Schema(type = "array",description = "lista de codigos de streamings" )
        List<StreamingResponse> streamings
) {
}
