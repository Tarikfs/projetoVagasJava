package com.tfs.projetoDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfs.projetoDemo.model.Vaga;


@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

}
