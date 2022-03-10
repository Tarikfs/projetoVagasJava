package com.tfs.projetoDemo.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.tfs.projetoDemo.model.Cargo;
import com.tfs.projetoDemo.model.Vaga;
import com.tfs.projetoDemo.repository.CargoRepository;

public class VagaForm {

	@NotNull
	@NotEmpty
	private String funcaoCargo;

	@NotNull
	@NotEmpty
	private String salario;

	@NotNull
	@NotEmpty
	private String localizacaoVaga;

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public void setLocalizacaoVaga(String localizacaoVaga) {
		this.localizacaoVaga = localizacaoVaga;
	}

	public Vaga converter(CargoRepository cargoRepository) {
		Cargo cargo = cargoRepository.findByFuncao(funcaoCargo);
		return new Vaga(salario, localizacaoVaga, cargo);
	}

}
