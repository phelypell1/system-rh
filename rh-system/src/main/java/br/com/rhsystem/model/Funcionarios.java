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
@Table(name = "db_funcionario")
public class Funcionarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_funcionario;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_supervisor", referencedColumnName = "id_supervisor")
	private Supervisor id_supervisor;
	
	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "matricula", nullable = false, length = 6)
	private String matricula;
	
	@Column(name = "matriculaSaneago", nullable = true, length = 7)
	private String matriculaSaneago;
	
	@Column(name = "valeTransporte", nullable = false)
	private boolean valeTransporte;
	
	@Column(name = "salario", nullable = false)
	private float salario;
	
	@Column(name = "locacao", nullable = true)
	private boolean locacao;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_banco", referencedColumnName = "id_banco")
	private Bancos id_banco;
	
	@Column(name = "agencia", nullable = true, length = 10)
	private String agencia;
	
	@Column(name = "op_tipo", nullable = true, length = 5)
	private String op_tipo;
	
	@Column(name = "numero_conta", nullable = true, length = 10)
	private String numero_conta;
	
	@Column(name = "exp_p_2012", nullable = true)
	private Date exp_p_2012;
	
	@Column(name = "exp_p_2013", nullable = true)
	private Date exp_p_2013;
	
	@Column(name = "exp_p_2014", nullable = true)
	private Date exp_p_2014;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cargo", nullable = false)
	private Cargos id_cargo;
	
	@Column(name = "ctps", nullable = false, length = 25)
	private String ctps;
	
	@Column(name = "serie", nullable = false, length = 10)
	private String serie;
	
	@Column(name = "dataNascimento", nullable = false)
	private Date dataNascimento;
	
	@Column(name = "cpf", nullable = false, length = 15)
	private String cpf;
	
	@Column(name = "rg", nullable = false, length = 10)
	private String rg;
	
	@Column(name = "pis", nullable = false, length = 50)
	private String pis;
	
	@Column(name = "data_emissao", nullable = true)
	private Date date_demissao;
	
	@Column(name = "situacao", nullable = false)
	private String situacao;

	public Long getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public Supervisor getId_supervisor() {
		return id_supervisor;
	}

	public void setId_supervisor(Supervisor id_supervisor) {
		this.id_supervisor = id_supervisor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMatriculaSaneago() {
		return matriculaSaneago;
	}

	public void setMatriculaSaneago(String matriculaSaneago) {
		this.matriculaSaneago = matriculaSaneago;
	}

	public boolean isValeTransporte() {
		return valeTransporte;
	}

	public void setValeTransporte(boolean valeTransporte) {
		this.valeTransporte = valeTransporte;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public boolean isLocacao() {
		return locacao;
	}

	public void setLocacao(boolean locacao) {
		this.locacao = locacao;
	}

	public Bancos getId_banco() {
		return id_banco;
	}

	public void setId_banco(Bancos id_banco) {
		this.id_banco = id_banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getOp_tipo() {
		return op_tipo;
	}

	public void setOp_tipo(String op_tipo) {
		this.op_tipo = op_tipo;
	}

	public String getNumero_conta() {
		return numero_conta;
	}

	public void setNumero_conta(String numero_conta) {
		this.numero_conta = numero_conta;
	}

	public Date getExp_p_2012() {
		return exp_p_2012;
	}

	public void setExp_p_2012(Date exp_p_2012) {
		this.exp_p_2012 = exp_p_2012;
	}

	public Date getExp_p_2013() {
		return exp_p_2013;
	}

	public void setExp_p_2013(Date exp_p_2013) {
		this.exp_p_2013 = exp_p_2013;
	}

	public Date getExp_p_2014() {
		return exp_p_2014;
	}

	public void setExp_p_2014(Date exp_p_2014) {
		this.exp_p_2014 = exp_p_2014;
	}

	public Cargos getId_cargo() {
		return id_cargo;
	}

	public void setId_cargo(Cargos id_cargo) {
		this.id_cargo = id_cargo;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public Date getDate_demissao() {
		return date_demissao;
	}

	public void setDate_demissao(Date date_demissao) {
		this.date_demissao = date_demissao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	

}
