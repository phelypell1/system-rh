import { bancos } from './../models/bancos.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BancosService {

  constructor(private http: HttpClient) { }

  buscarbancoss(): Observable<bancos> {
    return this.http.get<bancos>(`${environment.API}/bancos`);
  }

  buscarbancosPorId(idbancos: bancos): Observable<bancos> {
    return this.http.get<bancos>(`${environment.API}/bancos/${idbancos}`);
  }

  gravarbancos(bancos: bancos): Observable<bancos> {
    return this.http.post<bancos>(`${environment.API}/bancos`, bancos);
  }

  updatebancos(bancos: bancos): Observable<bancos> {
    return this.http.put<bancos>(`${environment.API}/bancos`, bancos);
  }

  excluirbancos(idbancos: number ): Observable<bancos> {
    return this.http.delete<bancos>(`${environment.API}/bancos/delete/${idbancos}`);
  }
}
