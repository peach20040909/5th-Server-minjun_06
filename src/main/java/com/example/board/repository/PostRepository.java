package com.example.board.repository;

import com.example.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository만 상속해도 save/findById/findAll/delete 등 기본 CRUD가 다 생김
public interface PostRepository extends JpaRepository<Post, Long> {
}
