import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { estados } from '../models/estados.model';

@Injectable({
  providedIn: 'root'
})
export class EstadosService {

  constructor(private http: HttpClient) { }

  buscarestadoss(): Observable<estados> {
    return this.http.get<estados>(`${environment.API}/estados`);
  }

  buscarestadosPorId(idestados: estados): Observable<estados> {
    return this.http.get<estados>(`${environment.API}/estados/${idestados}`);
  }

  gravarestados(estados: estados): Observable<estados> {
    return this.http.post<estados>(`${environment.API}/estados`, estados);
  }

  updateestados(estados: estados): Observable<estados> {
    return this.http.put<estados>(`${environment.API}/estados`, estados);
  }

  excluirestados(idestados: number ): Observable<estados> {
    return this.http.delete<estados>(`${environment.API}/estados/delete/${idestados}`);
  }
}
