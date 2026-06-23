package com.example.board.service;

import com.example.board.domain.Post;
import com.example.board.dto.PostRequest;
import com.example.board.dto.PostResponse;
import com.example.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 조회는 readOnly로 성능 최적화
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long create(PostRequest req) {
        Post post = new Post(req.getTitle(), req.getContent(), req.getAuthor());
        return postRepository.save(post).getId();
    }

    public List<PostResponse> findAll() {
        return postRepository.findAll().stream()
                .map(PostResponse::from)
                .toList();
    }

    public PostResponse findOne(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다. id=" + id));
        return PostResponse.from(post);
    }

    @Transactional
    public void update(Long id, PostRequest req) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다. id=" + id));
        post.update(req.getTitle(), req.getContent()); // 변경 감지(dirty checking)로 자동 UPDATE
    }

    @Transactional
    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
