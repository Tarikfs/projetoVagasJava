package com.tfs.projetoDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Vaga {

	@Id
	@NotNull
	@Column(name = "vagaID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vagaID;
	private String localizacaoVaga;
	private String dataOrigem;
	private String cargaHoraria;
	private String modeloDeTrabalho;
	private String modeloEscala;

}
