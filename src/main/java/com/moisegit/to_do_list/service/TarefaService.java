package com.moisegit.to_do_list.service;

import com.moisegit.to_do_list.dto.AtualizarTarefaDto;
import com.moisegit.to_do_list.dto.CriarTarefaDto;
import com.moisegit.to_do_list.dto.RespostaTarefaDto;
import com.moisegit.to_do_list.exception.NotFoundException;
import com.moisegit.to_do_list.mapstruct.TarefaMapper;
import com.moisegit.to_do_list.model.TarefaEntity;
import com.moisegit.to_do_list.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public void salvarTarefa(CriarTarefaDto criarTarefaDto) {
       tarefaRepository.save(tarefaMapper.tarefaEntity(criarTarefaDto));
    }

    public List<RespostaTarefaDto> findAll() {
        return tarefaMapper.listaTarefaDto(tarefaRepository.findAll());
    }

    public RespostaTarefaDto buscaporEmail(String email) {
        return tarefaMapper.tarefaDto(tarefaRepository.findByEmail(email));
    }

    public AtualizarTarefaDto atualizarTarefa(AtualizarTarefaDto atualizarTarefaDto) throws NotFoundException {
        // Buscar TarefaEntity e Verificar if Existe || Não.
        TarefaEntity tarefa = tarefaRepository.findById(atualizarTarefaDto.getTarefaid())
                .orElseThrow(() -> new NotFoundException("Tarefa não encontrada!"));
        // Aplica os Dados do DTO na entidade.
        tarefaMapper.atualizar(atualizarTarefaDto, tarefa);
        // Salva a entidade atualizada
        TarefaEntity tarefaAtualizada = tarefaRepository.save(tarefa);
        // Converte a Entidade salva em uma reposta Dto, retornada ao usuário
        return tarefaMapper.atualizando(tarefaAtualizada);
    }


}
