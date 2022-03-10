package com.tfs.projetoDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tfs.projetoDemo.model.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

	Page<Vaga> findByCargoFuncao(String funcaoCargo, Pageable paginacao);
}
