package com.example.hecto_project.domain;

import com.example.hecto_project.dto.BoardDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Board {
    private Long id;
    private String content;

    @Builder
    private Board(String content) {
        this.content = content;
    }

    public static Board of(String content) {
        return builder()
                .content(content)
                .build();
    }

}
