package com.marciosalesdev.movieflix.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRequest(@NotEmpty(message = "Nome de serviço Streaming é obrigatório. ")String name) {
}
