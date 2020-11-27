package br.com.rhsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "db_supervisor")
public class Supervisor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_supervisor")
	private Long id_supervisor;
	
	@Column(name = "nome_supervisor", nullable = false, length = 25)
	private String nome_supervisor;
	
	@Cascade(CascadeType.MERGE)
	@OneToOne
	@JoinColumn(name = "id_regiao", referencedColumnName = "id_regiao")
	private Regiao id_regiao;

	public Long getId_supervisor() {
		return id_supervisor;
	}

	public void setId_supervisor(Long id_supervisor) {
		this.id_supervisor = id_supervisor;
	}

	public String getNome_supervisor() {
		return nome_supervisor;
	}

	public void setNome_supervisor(String nome_supervisor) {
		this.nome_supervisor = nome_supervisor;
	}

	public Regiao getId_regiao() {
		return id_regiao;
	}

	public void setId_regiao(Regiao id_regiao) {
		this.id_regiao = id_regiao;
	}
	
}
