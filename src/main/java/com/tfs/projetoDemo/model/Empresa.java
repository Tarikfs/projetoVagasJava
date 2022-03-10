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

public class Empresa implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empresaID;
	private String email;
	private String senha;
	private String cnpj;
	private String endereco;

	@Override
	public String getAuthority() {
		return email;
	}

}
