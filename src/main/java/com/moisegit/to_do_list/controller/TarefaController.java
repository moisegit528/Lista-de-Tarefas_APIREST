package com.moisegit.to_do_list.controller;

import com.moisegit.to_do_list.dto.AtualizarTarefaDto;
import com.moisegit.to_do_list.dto.CriarTarefaDto;
import com.moisegit.to_do_list.dto.RespostaTarefaDto;
import com.moisegit.to_do_list.exception.NotFoundException;
import com.moisegit.to_do_list.repository.TarefaRepository;
import com.moisegit.to_do_list.service.TarefaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaRepository tarefaRepository;
    private final TarefaService tarefaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody CriarTarefaDto criarTarefaDto) {
        tarefaService.salvarTarefa(criarTarefaDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RespostaTarefaDto> findAll() {
        return tarefaService.findAll();
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public RespostaTarefaDto buscaporEmail(@PathVariable String email) {
        return tarefaService.buscaporEmail(email);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AtualizarTarefaDto atualizar(@RequestBody AtualizarTarefaDto atualizarTarefaDto) throws NotFoundException {
        tarefaService.atualizarTarefa(atualizarTarefaDto);
        return tarefaService.atualizarTarefa(atualizarTarefaDto);
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorEmail(@PathVariable String email) {
        tarefaRepository.deleteByEmail(email);
    }
}
