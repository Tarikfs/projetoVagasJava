package com.tfs.projetoDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfs.projetoDemo.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
