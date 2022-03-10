package com.tfs.projetoDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfs.projetoDemo.controller.dto.CargoDto;
import com.tfs.projetoDemo.model.Cargo;
import com.tfs.projetoDemo.repository.CargoRepository;

@RestController
public class CargoController {

	@Autowired
	private CargoRepository cargoRepository;

	@RequestMapping("/cargos")
	public List<CargoDto> lista() {
		List<Cargo> cargo = cargoRepository.findAll();
		return CargoDto.converter(cargo);
	}

}
