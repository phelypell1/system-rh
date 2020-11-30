import { locacao } from './../models/locacaoVeiculo.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LocacaoService {

  constructor(private http: HttpClient) { }

  buscarlocacaoVeiculoss(): Observable<locacao> {
    return this.http.get<locacao>(`${environment.API}/locacao`);
  }

  buscarlocacaoVeiculosPorId(idlocacao: locacao): Observable<locacao> {
    return this.http.get<locacao>(`${environment.API}/locacao/${idlocacao}`);
  }

  gravarlocacaoVeiculos(locacaoVeiculos: locacao): Observable<locacao> {
    return this.http.post<locacao>(`${environment.API}/locacao`, locacaoVeiculos);
  }

  updatelocacaoVeiculos(locacaoVeiculos: locacao): Observable<locacao> {
    return this.http.put<locacao>(`${environment.API}/locacao`, locacaoVeiculos);
  }

  excluirlocacaoVeiculos(idlocacaoVeiculos: number ): Observable<locacao> {
    return this.http.delete<locacao>(`${environment.API}/locacao/delete/${idlocacaoVeiculos}`);
  }
}
