import { BancosService } from './../../core/services/bancos.service';
import { bancos } from './../../core/models/bancos.model';
import { CargosService } from './../../core/services/cargos.service';
import { cargos } from './../../core/models/cargos.model';
import { SelectItem } from 'primeng';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-funcionarios',
  templateUrl: './funcionarios.component.html',
  styleUrls: ['./funcionarios.component.css']
})
export class FuncionariosComponent implements OnInit {

  valeTransporte: any[];
  locacao: any[];
  cargos: cargos;
  situacao: any[];
  banco: bancos;

  constructor(
    private cargosService: CargosService,
    private bancoService: BancosService
  ) {

    this.valeTransporte=[
      {label: "Optante", value: true},
      {label: "Não optante", value: false}
    ];

    this.locacao=[
      {label: "SIM", value: true},
      {label: "NÃO", value: false}
    ];

    this.cargosService.buscarcargoss().subscribe(data => {
      this.cargos = data;
    });

    this.situacao = [
      {label: "ATIVO", value: "Ativo"},
      {label: "AFASTADO", value: "Afastado"},
      {label: "DEMITIDO", value: "Demitido"},
      {label: "INSS", value: "INSS"}
    ];

    this.bancoService.buscarbancoss().subscribe(data => {
      this.banco = data;

    });
  }

  ngOnInit(): void {
  }

}
