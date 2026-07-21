package com.moisegit.to_do_list.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarTarefaDto {

    private Integer Tarefaid;
    private String email;
    private String titulo;
    private String descricao;


}
