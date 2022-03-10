package com.tfs.projetoDemo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.tfs.projetoDemo.model.Vaga;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VagaDto {

	private Long vagaID;
	private String localizacaoVaga;
	private String dataOrigem;

	public VagaDto(Vaga vaga) {
		this.vagaID = vaga.getVagaID();
		this.localizacaoVaga = vaga.getLocalizacaoVaga();
		this.dataOrigem = vaga.getDataOrigem();
	}

	public static List<VagaDto> converter(List<Vaga> vaga) {
		return vaga.stream().map(VagaDto::new).collect(Collectors.toList());
	}

}
