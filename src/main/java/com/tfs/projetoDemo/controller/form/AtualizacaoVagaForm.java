package com.tfs.projetoDemo.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.tfs.projetoDemo.model.Vaga;
import com.tfs.projetoDemo.repository.VagaRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoVagaForm {

	@NotNull
	@NotEmpty
	private String salario;

	@NotNull
	@NotEmpty
	private String localizacaoVaga;

	public Vaga atualizar(Long vagaID, VagaRepository vagaRepository) {
		Vaga vaga = vagaRepository.getById(vagaID);

		vaga.setSalario(salario);
		vaga.setLocalizacaoVaga(localizacaoVaga);

		return vaga;
	}

}
