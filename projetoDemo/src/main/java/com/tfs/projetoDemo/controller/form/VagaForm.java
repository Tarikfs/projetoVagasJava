package com.tfs.projetoDemo.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VagaForm {

	@NotNull
	@NotEmpty
	private String cargo;

	@NotNull
	@NotEmpty
	private String salario;

	@NotNull
	@NotEmpty
	private String localizacaoVaga;

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public void setLocalizacaoVaga(String localizacaoVaga) {
		this.localizacaoVaga = localizacaoVaga;
	}

}
