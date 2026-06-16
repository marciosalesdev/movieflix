package com.marciosalesdev.movieflix.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record CategoryRequest(@NotEmpty(message = "Nome da Categoria é obrigatório. ") String name) {
}
