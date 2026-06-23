package com.example.board.dto;

import com.example.board.domain.Post;

import java.time.LocalDateTime;

// 서버 -> 클라이언트 (응답용 DTO). Entity를 직접 노출하지 않는다!
public record PostResponse(
        Long id,
        String title,
        String content,
        String author,
        LocalDateTime createdAt
) {
    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getAuthor(),
                post.getCreatedAt()
        );
    }
}
