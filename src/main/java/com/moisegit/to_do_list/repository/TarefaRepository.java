package com.moisegit.to_do_list.repository;

import com.moisegit.to_do_list.dto.RespostaTarefaDto;
import com.moisegit.to_do_list.model.TarefaEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TarefaRepository extends JpaRepository<TarefaEntity, Integer> { ;
    @Transactional
    TarefaEntity findByEmail(String email);
    @Transactional
    void deleteByEmail(String email);

}
