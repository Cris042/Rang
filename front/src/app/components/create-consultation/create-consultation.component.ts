import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { IDoctorDTO } from 'src/app/dto/IDoctorDTO';
import { AuthService } from 'src/app/services/auth.service';
import { ConsultationService } from 'src/app/services/consultations.service';

@Component({
  selector: 'app-create-consultation',
  templateUrl: './create-consultation.component.html',
  styleUrls: ['./create-consultation.component.css']
})
export class CreateConsultationComponent 
{
    constructor
    ( 
      private consultationService: ConsultationService,
      private authService: AuthService, 
      private router: Router, 
    ) {}

    public doctors!: IDoctorDTO[];

    newConsult = {      
      state : "Aceita",
      crm : '',
      cpf : '',
      date : '',
      time : ''
    };

    ngOnInit( ): void 
    { 
        this.getDoctors();
    }

    getDoctors(): void 
    { 
      this.consultationService.getDoctor().subscribe
      (
        (response: IDoctorDTO[]) => {
          this.doctors = response
        },
  
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }

    buildForm() {}

    register() 
    {
    
      this.consultationService.register
      (
          this.newConsult.state,
          this.newConsult.crm,
          this.newConsult.cpf,
          this.newConsult.date,
          this.newConsult.time
      ).subscribe();

      
      this.router.navigate(['/consulta']);
    }
}
