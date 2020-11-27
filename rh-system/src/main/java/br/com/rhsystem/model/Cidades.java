package br.com.rhsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "db_cidade")
public class Cidades {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cidade;
	
	@Column(name = "cidade", nullable = false, length = 255)
	private String cidade;
	
	@Cascade(CascadeType.MERGE)
	@ManyToOne
	@JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
	private Estados id_estado;

	public Long getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(Long id_cidade) {
		this.id_cidade = id_cidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estados getId_estado() {
		return id_estado;
	}

	public void setId_estado(Estados id_estado) {
		this.id_estado = id_estado;
	}
	
}
