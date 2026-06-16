package com.marciosalesdev.movieflix.controller;

import com.marciosalesdev.movieflix.controller.request.StreamingRequest;
import com.marciosalesdev.movieflix.controller.response.StreamingResponse;
import com.marciosalesdev.movieflix.entity.Streaming;
import com.marciosalesdev.movieflix.mapper.StreamingMapper;
import com.marciosalesdev.movieflix.service.StreamingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/movieflix/streaming")
@RestController
@RequiredArgsConstructor
@Tag(name = "Streamings", description = "Recurso responsavel pelo gerenciamento a streamings dos filmes")
public class StreamingController {

    private final StreamingService service;


    @GetMapping
    public ResponseEntity<List<StreamingResponse>> listCategory() {
        return ResponseEntity.ok(service.findAll()
                .stream()
                .map(
                        streaming ->
                                StreamingMapper.toStreamingResponse(streaming))
                .toList());
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> saveCategory(@Valid @RequestBody StreamingRequest streamingRequest) {
        Streaming streaming = StreamingMapper.toStreaming(streamingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(service.saveStreaming(streaming)));

    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable Long id) {
        return service.findById(id).map(streaming ->
                ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming))).orElse(
                ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delebeById(id);
    }
}
