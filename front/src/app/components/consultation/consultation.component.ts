import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { IConsultationDTO } from 'src/app/dto/IConsultationDTO';
import { HttpErrorResponse } from '@angular/common/http';
import { ConsultationService } from 'src/app/services/consultations.service';

@Component
({
  selector: 'app-consultation',
  templateUrl: './consultation.component.html',
  styleUrls: ['./consultation.component.css'],
})
export class ConsultationComponent 
{
  constructor
  ( 
    private consultationService: ConsultationService,
    private authService: AuthService, 
  ) {}

  public consultation!: IConsultationDTO[];

  ngOnInit() 
  {
  }

  public getConsultation( cpf: string ): void 
  {
    this.consultationService.getProductsByCpf( cpf ).subscribe
    (
      (response: IConsultationDTO[]) => {
        console.log( cpf );
        this.consultation = response
      },

      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  shouldShowHeader(): boolean 
  {
    return true; 
  }

  logout(): void 
  {
    this.authService.logout(); 
  }
}
