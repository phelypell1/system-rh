import { supervisor } from './../models/supervisor.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SupervisorService {

  constructor(private http: HttpClient) { }

  buscarsupervisorVeiculoss(): Observable<supervisor> {
    return this.http.get<supervisor>(`${environment.API}/supervisorVeiculos`);
  }

  buscarsupervisorVeiculosPorId(idsupervisor: supervisor): Observable<supervisor> {
    return this.http.get<supervisor>(`${environment.API}/supervisor/${idsupervisor}`);
  }

  gravarsupervisorVeiculos(supervisor: supervisor): Observable<supervisor> {
    return this.http.post<supervisor>(`${environment.API}/supervisor`, supervisor);
  }

  updatesupervisorVeiculos(supervisor: supervisor): Observable<supervisor> {
    return this.http.put<supervisor>(`${environment.API}/supervisor`, supervisor);
  }

  excluirsupervisorVeiculos(idsupervisor: number ): Observable<supervisor> {
    return this.http.delete<supervisor>(`${environment.API}/supervisor/delete/${idsupervisor}`);
  }
}
