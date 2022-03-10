package com.tfs.projetoDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfs.projetoDemo.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	Optional<Empresa> findByEmail(String Empresa);

}
