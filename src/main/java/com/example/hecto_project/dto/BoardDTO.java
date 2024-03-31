package com.example.hecto_project.dto;

import com.example.hecto_project.domain.Board;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardDTO {
    private Long id;

    @NotEmpty(message = "내용을 입력해주세요")
    private String content;

    @Builder
    private BoardDTO(String content) {
        this.content = content;
    }

    public static BoardDTO of(String content) {
        return builder()
                .content(content)
                .build();
    }
}