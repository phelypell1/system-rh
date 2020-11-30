import { cargos } from './cargos.model';
import { bancos } from './bancos.model';
import { supervisor } from './supervisor.model';
export class funcionarios {

	id_funcionario: number;
	id_supervisor: supervisor;
	nome: string;
	matricula: string;
	matriculaSaneago: string;
	valeTransporte: boolean;
	salario: Float32Array;
	locacao: boolean;
	id_banco: bancos;
	agencia: string;
	op_tipo: string;
	numero_conta: string;
	exp_p_2012: Date;
	exp_p_2013: Date;
	exp_p_2014: Date;
	id_cargo: cargos;
	ctps: string;
	serie: string;
	dataNascimento: Date;
	cpf: string;
	rg: string;
	pis: string;
	date_demissao: Date;
  situacao: string;

}
