package com.marciosalesdev.movieflix.controller.request;

import lombok.Builder;

@Builder
public record StreamingRequest(String name) {
}
