package com.moisegit.to_do_list.dto;

import com.moisegit.to_do_list.service.TarefaService;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespostaTarefaDto {

    private String email;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
}
