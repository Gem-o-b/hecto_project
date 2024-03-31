package com.example.hecto_project.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardUpdateDTO {

    @NotNull(message = "ID 값을 입력해주세요.")
    @Min(value = 1, message = "ID의 최소값은 0입니다.")
    private Long id;

    @NotEmpty(message = "내용을 입력해주세요")
    private String content;

    @Builder
    private BoardUpdateDTO(String content) {
        this.content = content;
    }

    public static BoardUpdateDTO of(String content) {
        return builder()
                .content(content)
                .build();
    }
}