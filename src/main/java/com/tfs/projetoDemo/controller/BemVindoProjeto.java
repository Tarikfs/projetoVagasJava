package com.tfs.projetoDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BemVindoProjeto {
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Bem vindo ao projeto de demonstração! Esse projeto é um projeto focado em demonstrar meu conhecimento em desenvolvimento de backend develepment,"
				+ " Esse projeto demonstra a utilização de java com SpringBoot em comunição com o banco de dados Microsoft SQL Server. ";
	}
}
