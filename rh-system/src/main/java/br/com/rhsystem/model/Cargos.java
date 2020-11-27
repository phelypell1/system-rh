package br.com.rhsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "db_cargos")
public class Cargos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cargos")
	private Long id_cargos;
	
	@Column(name = "cargo", nullable = false, length = 50)
	private String cargo;
	
	@Column(name = "descricao", nullable = true, length = 255)
	private String descrivao;

	public Long getId_cargos() {
		return id_cargos;
	}

	public void setId_cargos(Long id_cargos) {
		this.id_cargos = id_cargos;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescrivao() {
		return descrivao;
	}

	public void setDescrivao(String descrivao) {
		this.descrivao = descrivao;
	}
	
}

