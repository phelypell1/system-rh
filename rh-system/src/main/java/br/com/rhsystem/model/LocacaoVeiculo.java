package br.com.rhsystem.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "db_locacao_veiculo")
public class LocacaoVeiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_locacao")
	private Long id_locacao;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_supervisor", referencedColumnName = "id_supervisor")
	private Supervisor id_supervisor;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_funcionario", referencedColumnName = "id_funcionario")
	private Funcionarios id_funcionario;
	
	@Column(name = "placa_veiculo", nullable = false, length = 5)
	private String placa_veiculo;
	
	@Column(name = "dt_venc_cnh", nullable = false)
	private Date dt_venc_cnh;
	
	@Column(name = "ano_dut", nullable = false, length = 4)
	private String ano_dut;
	
	@Column(name = "observacao", nullable = true, length = 255)
	private String observacao;
	
	@Column(name = "inicio_locacao", nullable = false)
	private Date inicio_locacao;
	
	@Column(name = "situacao", nullable = false)
	private String situacao;

	public Long getId_locacao() {
		return id_locacao;
	}

	public void setId_locacao(Long id_locacao) {
		this.id_locacao = id_locacao;
	}

	public Supervisor getId_supervisor() {
		return id_supervisor;
	}

	public void setId_supervisor(Supervisor id_supervisor) {
		this.id_supervisor = id_supervisor;
	}

	public Funcionarios getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Funcionarios id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getPlaca_veiculo() {
		return placa_veiculo;
	}

	public void setPlaca_veiculo(String placa_veiculo) {
		this.placa_veiculo = placa_veiculo;
	}

	public Date getDt_venc_cnh() {
		return dt_venc_cnh;
	}

	public void setDt_venc_cnh(Date dt_venc_cnh) {
		this.dt_venc_cnh = dt_venc_cnh;
	}

	public String getAno_dut() {
		return ano_dut;
	}

	public void setAno_dut(String ano_dut) {
		this.ano_dut = ano_dut;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getInicio_locacao() {
		return inicio_locacao;
	}

	public void setInicio_locacao(Date inicio_locacao) {
		this.inicio_locacao = inicio_locacao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}