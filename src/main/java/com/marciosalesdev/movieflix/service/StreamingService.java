package com.marciosalesdev.movieflix.service;

import com.marciosalesdev.movieflix.entity.Streaming;
import com.marciosalesdev.movieflix.repository.StreamingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public List<Streaming> findAll() {
        return streamingRepository.findAll();
    }

    @Transactional
    public Streaming saveStreaming(Streaming streaming) {
        return streamingRepository.save(streaming);
    }


    public Optional<Streaming> findById(Long id) {
        return streamingRepository.findById(id);
    }

    @Transactional
    public void delebeById(Long id) {
        streamingRepository.deleteById(id);
    }
}

