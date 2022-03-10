package com.tfs.projetoDemo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Vaga {

	@Id
	@NotNull
	@Column(name = "vagaID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vagaID;
	private String salario;
	private String funcao;
	private String localizacaoVaga;
	private LocalDateTime dataOrigem = LocalDateTime.now();
	private String cargaHoraria;
	private String modeloDeTrabalho;
	private String modeloEscala;
	@Enumerated(EnumType.STRING)
	private StatusVaga status = StatusVaga.NAO_RESPONDIDO;
	@ManyToOne
	private Usuario empresa;
	@ManyToOne
	private Usuario pessoas;
	@ManyToOne
	private Cargo cargo;

	public Vaga(@NotNull @NotEmpty String salario, @NotNull @NotEmpty String localizacaoVaga, Cargo cargo) {
		this.salario = salario;
		this.localizacaoVaga = localizacaoVaga;
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vagaID == null) ? 0 : vagaID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaga other = (Vaga) obj;
		if (vagaID == null) {
			if (other.vagaID != null)
				return false;
		} else if (!vagaID.equals(other.vagaID))
			return false;
		return true;
	}

	public Usuario getNomeEmpresa() {
		return empresa;
	}

}
