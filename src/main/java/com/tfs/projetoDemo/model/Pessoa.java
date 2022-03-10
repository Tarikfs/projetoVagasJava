package com.tfs.projetoDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter

public class Pessoa implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pessoaID;

	private String email;

	private String senha;

	private String cpf;

	private String dataNascimento;

	private String statusCivil;

	private String enderecoPessoa;

	private String StatusProfissional;

	private String formacaoAcademica;

	private String certificacao;

	private String hitoricoExperiencia;

	@Override
	public String getAuthority() {
		return email;
	}

}
