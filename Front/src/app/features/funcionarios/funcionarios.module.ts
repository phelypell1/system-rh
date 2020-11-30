import { InputMaskModule } from 'primeng/inputmask';
import { FormsModule } from '@angular/forms';
import { FuncionariosComponent } from './funcionarios.component';
import {PanelModule} from 'primeng/panel';
import { FuncionariosRoutingModule } from './funcionarios.routing';
import { AppCommonModule } from './../../app.common.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {InputNumberModule} from 'primeng/inputnumber';



@NgModule({
  declarations: [FuncionariosComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    FuncionariosRoutingModule,
    PanelModule,
    FormsModule,
    InputMaskModule,
    InputNumberModule

  ]
})
export class FuncionariosModule { }
