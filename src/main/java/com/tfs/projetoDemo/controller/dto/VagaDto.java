package com.tfs.projetoDemo.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import com.tfs.projetoDemo.model.Vaga;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VagaDto {

	private Long vagaID;
	private String localizacaoVaga;
	private LocalDateTime dataOrigem;
	private String empresa;

	public VagaDto(Vaga vaga) {
		this.vagaID = vaga.getVagaID();
		this.localizacaoVaga = vaga.getLocalizacaoVaga();
		this.dataOrigem = vaga.getDataOrigem();
	}

	public static Page<VagaDto> converter(Page<Vaga> vaga) {
		return vaga.map(VagaDto::new);
	}

}
