package br.com.rhsystem.model;

import java.util.Date;

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
@Table(name = "db_regiao")
public class Regiao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_regiao")
	private Long id_regiao;
	
	@Column(name = "regiao", nullable = false, length = 15)
	private String regiao;
	
	@Column(name = "date_registro", nullable = false)
	private Date date_registro;


	public Long getId_regiao() {
		return id_regiao;
	}


	public void setId_regiao(Long id_regiao) {
		this.id_regiao = id_regiao;
	}


	public String getRegiao() {
		return regiao;
	}


	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}


	public Date getDate_registro() {
		return date_registro;
	}


	public void setDate_registro(Date date_registro) {
		this.date_registro = date_registro;
	}

}
