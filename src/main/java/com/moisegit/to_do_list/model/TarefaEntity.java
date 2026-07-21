package com.moisegit.to_do_list.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Tarefas")
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;
    @NotBlank
    @Column(unique = true, nullable = false)
    private String titulo;
    @NotBlank
    private String descricao;

    @CreationTimestamp
    private LocalDateTime dataCriacao;
}
