package com.marciosalesdev.movieflix.mapper;

import com.marciosalesdev.movieflix.controller.request.StreamingRequest;
import com.marciosalesdev.movieflix.controller.response.StreamingResponse;
import com.marciosalesdev.movieflix.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest) {
        return Streaming.builder()
                .name(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}

