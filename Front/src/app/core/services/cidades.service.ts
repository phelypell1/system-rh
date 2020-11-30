import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { cidades } from '../models/cidades.model';

@Injectable({
  providedIn: 'root'
})
export class CidadesService {

  constructor(private http: HttpClient) { }

  buscarcidadess(): Observable<cidades> {
    return this.http.get<cidades>(`${environment.API}/cidades`);
  }

  buscarcidadesPorId(idcidades: cidades): Observable<cidades> {
    return this.http.get<cidades>(`${environment.API}/cidades/${idcidades}`);
  }

  gravarcidades(cidades: cidades): Observable<cidades> {
    return this.http.post<cidades>(`${environment.API}/cidades`, cidades);
  }

  updatecidades(cidades: cidades): Observable<cidades> {
    return this.http.put<cidades>(`${environment.API}/cidades`, cidades);
  }

  excluircidades(idcidades: number ): Observable<cidades> {
    return this.http.delete<cidades>(`${environment.API}/cidades/delete/${idcidades}`);
  }
