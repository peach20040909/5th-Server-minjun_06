package com.example.board.controller;

import com.example.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Thymeleaf 화면용 (REST API와 별개). 최대한 간단하게 목록만.
@Controller
@RequiredArgsConstructor
public class PostViewController {

    private final PostService postService;

    @GetMapping("/posts")
    public String list(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "posts"; // templates/posts.html
    }
}
