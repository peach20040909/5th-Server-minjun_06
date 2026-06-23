package com.example.board.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA가 쓰는 기본 생성자(외부에서 막 못 만들게 PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동 증가
    private Long id;

    private String title;

    @Column(length = 1000)
    private String content;

    private String author;

    private LocalDateTime createdAt;

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    // 수정은 setter 대신 의미 있는 메서드로 (엔티티 변경은 여기서만)
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
