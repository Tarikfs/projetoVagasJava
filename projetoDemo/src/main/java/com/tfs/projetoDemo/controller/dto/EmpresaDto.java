package com.tfs.projetoDemo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.tfs.projetoDemo.model.Empresa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaDto {

	private Long empresaID;

	private String email;

	private String endereco;

	public EmpresaDto(Empresa empresa) {
		this.empresaID = empresa.getEmpresaID();
		this.email = empresa.getEmail();
		this.endereco = empresa.getEndereco();
	}

	public static List<EmpresaDto> converter(List<Empresa> empresa) {
		return empresa.stream().map(EmpresaDto::new).collect(Collectors.toList());
	}

}
