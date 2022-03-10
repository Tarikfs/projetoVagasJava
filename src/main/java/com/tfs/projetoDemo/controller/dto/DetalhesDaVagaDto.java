package com.tfs.projetoDemo.controller.dto;

import java.time.LocalDateTime;

import com.tfs.projetoDemo.model.StatusVaga;
import com.tfs.projetoDemo.model.Usuario;
import com.tfs.projetoDemo.model.Vaga;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetalhesDaVagaDto {

	private Long vagaID;
	private String cargo;
	private String salario;
	private String localizacaoVaga;
	private LocalDateTime dataOrigem;
	private String cargaHoraria;
	private String modeloDeTrabalho;
	private String modeloEscala;
	private Usuario nomeEmpresa;
	private StatusVaga status;

	public DetalhesDaVagaDto(Vaga vaga) {
		this.vagaID = vaga.getVagaID();
		this.salario = vaga.getSalario();
		this.localizacaoVaga = vaga.getLocalizacaoVaga();
		this.dataOrigem = vaga.getDataOrigem();
		this.cargaHoraria = vaga.getCargaHoraria();
		this.modeloDeTrabalho = vaga.getModeloDeTrabalho();
		this.modeloEscala = vaga.getModeloEscala();
		this.nomeEmpresa = vaga.getNomeEmpresa();

	}
}
