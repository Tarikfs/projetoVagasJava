package com.tfs.projetoDemo.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.tfs.projetoDemo.model.Pessoa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDto {

	private Long pessoaID;

	private String email;

	private String enderecoPessoa;

	private String certificacao;

	private String formacaoAcademica;

	private String hitoricoExperiencia;

	public PessoaDto(Pessoa pessoa) {
		this.pessoaID = pessoa.getPessoaID();
		this.email = pessoa.getEmail();
		this.enderecoPessoa = pessoa.getEnderecoPessoa();
		this.certificacao = pessoa.getCertificacao();
		this.formacaoAcademica = pessoa.getFormacaoAcademica();
		this.hitoricoExperiencia = pessoa.getHitoricoExperiencia();
	}

	public static List<PessoaDto> converter(List<Pessoa> pessoa) {
		return pessoa.stream().map(PessoaDto::new).collect(Collectors.toList());
	}

}
