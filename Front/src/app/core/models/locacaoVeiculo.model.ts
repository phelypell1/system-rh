import { funcionarios } from './funcionarios.model';
import { supervisor } from './supervisor.model';
export class locacao {
	id_locacao: number;
	id_supervisor: supervisor;
	id_funcionario: funcionarios;
	placa_veiculo: string;
	dt_venc_cnh: string;
  ano_dut: string;
	observacao: string;
	inicio_locacao: string;
	situacao: string;
}
