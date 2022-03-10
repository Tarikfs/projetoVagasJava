package com.tfs.projetoDemo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cargoID;
	private String funcao;
	private String salario;
	@Enumerated(EnumType.STRING)
	private StatusCargo status = StatusCargo.NAO_RESPONDIDO;

}