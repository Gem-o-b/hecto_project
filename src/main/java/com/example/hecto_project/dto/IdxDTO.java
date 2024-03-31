package com.example.hecto_project.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IdxDTO {
    private Long id;
    @Builder
    private IdxDTO(Long id) {
        this.id = id;

    }

    public static IdxDTO of(Long id) {
        return builder()
                .id(id)
                .build();
    }
}