package com.tfs.projetoDemo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.tfs.projetoDemo.model.Cargo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoDto {
	private Long cargoID;
	private String funcao;
	private String salario;

	public CargoDto(Cargo cargo) {
		this.cargoID = cargo.getCargoID();
		this.funcao = cargo.getFuncao();
		this.salario = cargo.getSalario();
	}

	public static List<CargoDto> converter(List<Cargo> cargo) {
		return cargo.stream().map(CargoDto::new).collect(Collectors.toList());
	}

}
