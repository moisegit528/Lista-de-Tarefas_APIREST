package com.moisegit.to_do_list.mapstruct;

import com.moisegit.to_do_list.dto.AtualizarTarefaDto;
import com.moisegit.to_do_list.dto.CriarTarefaDto;
import com.moisegit.to_do_list.dto.RespostaTarefaDto;
import com.moisegit.to_do_list.model.TarefaEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    @Mapping(target = "dataCriacao", ignore = true)
    @Mapping(target = "id",ignore = true)
    TarefaEntity tarefaEntity(CriarTarefaDto criarTarefaDto); // converte DTO para ENTITY

    // Convertendo o ENTITY para DTO de resposta
    RespostaTarefaDto tarefaDto(TarefaEntity tarefaEntity);

    // converte Lista Entity para uma Lista de resposta DTO.
    List<RespostaTarefaDto> listaTarefaDto(List<TarefaEntity> listaTarefas);

    // ignorar os campos em brancos
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    // aplica os dados da "AtualizarTarefaDto" dentro da entidade existente "TarefaEntity"
    void atualizar(AtualizarTarefaDto atualizarTarefaDto, @MappingTarget TarefaEntity tarefaEntity);
    // converte entidade "TarefaEntity" para DTO "AtualizarTarefaDto" de resposta
    AtualizarTarefaDto atualizando(TarefaEntity entity);

}
