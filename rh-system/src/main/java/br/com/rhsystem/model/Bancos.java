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
@Table(name = "db_bancos")
public class Bancos {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_banco")
	private Long id_banco;
	
	@Column(name = "codigo_banco", nullable = true, length = 6)
	private String codigo_banco;
	
	@Column(name = "nome_banco", nullable = false, length = 150)
	private String nome_banco;
	
	@Column(name = "bancoAbrev", nullable = true, length = 150)
	private String bancoAbrev;

	public Long getId_banco() {
		return id_banco;
	} 

	public void setId_banco(Long id_banco) {
		this.id_banco = id_banco;
	}

	public String getNome_banco() {
		return nome_banco;
	}

	public void setNome_banco(String nome_banco) {
		this.nome_banco = nome_banco;
	}

	public String getBancoAbrev() {
		return bancoAbrev;
	}

	public void setBancoAbrev(String bancoAbrev) {
		this.bancoAbrev = bancoAbrev;
	}

	public String getCodigo_banco() {
		return codigo_banco;
	}

	public void setCodigo_banco(String codigo_banco) {
		this.codigo_banco = codigo_banco;
	}
	
	
}
