import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { funcionarios } from '../models/funcionarios.model';

@Injectable({
  providedIn: 'root'
})
export class FuncionariosService {

  constructor(private http: HttpClient) { }

  buscarfuncionarioss(): Observable<funcionarios> {
    return this.http.get<funcionarios>(`${environment.API}/funcionarios`);
  }

  buscarfuncionariosPorId(idfuncionarios: funcionarios): Observable<funcionarios> {
    return this.http.get<funcionarios>(`${environment.API}/funcionarios/${idfuncionarios}`);
  }

  gravarfuncionarios(funcionarios: funcionarios): Observable<funcionarios> {
    return this.http.post<funcionarios>(`${environment.API}/funcionarios`, funcionarios);
  }

  updatefuncionarios(funcionarios: funcionarios): Observable<funcionarios> {
    return this.http.put<funcionarios>(`${environment.API}/funcionarios`, funcionarios);
  }

  excluirfuncionarios(idfuncionarios: number ): Observable<funcionarios> {
    return this.http.delete<funcionarios>(`${environment.API}/funcionarios/delete/${idfuncionarios}`);
  }
}
