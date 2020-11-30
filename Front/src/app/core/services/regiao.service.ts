import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { regiao } from '../models/regiao.model';

@Injectable({
  providedIn: 'root'
})
export class RegiaoService {

  constructor(private http: HttpClient) { }

  buscarregiaoVeiculoss(): Observable<regiao> {
    return this.http.get<regiao>(`${environment.API}/regiao`);
  }

  buscarregiaoVeiculosPorId(idregiao: regiao): Observable<regiao> {
    return this.http.get<regiao>(`${environment.API}/regiao/${idregiao}`);
  }

  gravarregiaoVeiculos(regiaoVeiculos: regiao): Observable<regiao> {
    return this.http.post<regiao>(`${environment.API}/regiao`, regiaoVeiculos);
  }

  updateregiaoVeiculos(regiaoVeiculos: regiao): Observable<regiao> {
    return this.http.put<regiao>(`${environment.API}/regiao`, regiaoVeiculos);
  }

  excluirregiaoVeiculos(idregiaoVeiculos: number ): Observable<regiao> {
    return this.http.delete<regiao>(`${environment.API}/regiao/delete/${idregiaoVeiculos}`);
  }
}
