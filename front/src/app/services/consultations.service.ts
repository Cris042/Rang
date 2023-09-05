import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { IConsultationDTO } from 'src/app/dto/IConsultationDTO';
import { IDoctorDTO } from 'src/app/dto/IDoctorDTO';

@Injectable({
  providedIn: 'root'
})
export class ConsultationService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient, private router: Router) 
  {
  }
  
  getProducts(): Observable<IConsultationDTO[]> {
    return this.http.get<IConsultationDTO[]>(`${this.apiUrl}/consult/list`);
  }

  getDoctor(): Observable<IDoctorDTO[]> {
    return this.http.get<IDoctorDTO[]>(`${this.apiUrl}/doctor/list`);
  }

  getProductsByCpf( cpf : String ): Observable<IConsultationDTO[]> {
    return this.http.get<IConsultationDTO[]>(`${this.apiUrl}/consult/list/${cpf}`);
  }

  register(state: string, crm: string, cpf: string, date: string, time: string): Observable<any> 
  {
    const body = { state, crm, cpf, date, time };
    return this.http.post<any>(`${this.apiUrl}/consult/add`, body);
  }
  
}
