import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { cargos } from '../models/cargos.model';

@Injectable({
  providedIn: 'root'
})
export class CargosService {

  constructor(private http: HttpClient) { }

  buscarcargoss(): Observable<cargos> {
    return this.http.get<cargos>(`${environment.API}/cargos`);
  }

  buscarcargosPorId(idcargos: cargos): Observable<cargos> {
    return this.http.get<cargos>(`${environment.API}/cargos/${idcargos}`);
  }

  gravarcargos(cargos: cargos): Observable<cargos> {
    return this.http.post<cargos>(`${environment.API}/cargos`, cargos);
  }

  updatecargos(cargos: cargos): Observable<cargos> {
    return this.http.put<cargos>(`${environment.API}/cargos`, cargos);
  }

  excluircargos(idcargos: number ): Observable<cargos> {
    return this.http.delete<cargos>(`${environment.API}/cargos/delete/${idcargos}`);
  }
}
