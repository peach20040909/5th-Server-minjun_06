package com.example.board.controller;

import com.example.board.dto.PostRequest;
import com.example.board.dto.PostResponse;
import com.example.board.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController // @Controller + @ResponseBody : 리턴값이 JSON으로 변환됨
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    // CREATE : POST /api/posts
    @PostMapping
    public ResponseEntity<Long> create(@Valid @RequestBody PostRequest req) {
        Long id = postService.create(req);
        return ResponseEntity.created(URI.create("/api/posts/" + id)).body(id); // 201 Created
    }

    // READ(전체) : GET /api/posts
    @GetMapping
    public List<PostResponse> findAll() {
        return postService.findAll();
    }

    // READ(단건) : GET /api/posts/{id}
    @GetMapping("/{id}")
    public PostResponse findOne(@PathVariable Long id) {
        return postService.findOne(id);
    }

    // UPDATE : PUT /api/posts/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody PostRequest req) {
        postService.update(id, req);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    // DELETE : DELETE /api/posts/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
