package com.tfs.projetoDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfs.projetoDemo.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

	Cargo findByFuncao(String funcao);

}
