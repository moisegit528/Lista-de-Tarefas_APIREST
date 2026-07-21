package com.moisegit.to_do_list.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CriarTarefaDto {

    @NotBlank
    private String email;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
}
