package com.tfs.projetoDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfs.projetoDemo.controller.dto.VagaDto;
import com.tfs.projetoDemo.model.Vaga;
import com.tfs.projetoDemo.repository.VagaRepository;

@RestController
public class VagaController {

	@Autowired
	private VagaRepository vagaRepository;

	@RequestMapping("/vagas")
	public List<VagaDto> lista() {
		List<Vaga> vaga = vagaRepository.findAll();
		return VagaDto.converter(vaga);
	}

}
