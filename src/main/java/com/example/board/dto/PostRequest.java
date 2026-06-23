package com.example.board.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

// 클라이언트 -> 서버 (생성/수정 요청용 DTO)
@Getter
public class PostRequest {

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    @NotBlank(message = "작성자는 필수입니다.")
    private String author;
}
