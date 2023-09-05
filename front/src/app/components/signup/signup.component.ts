import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component
({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent 
{
  newUser = {
    cpf: '',
    username: '',
    password: '',
    role: ''
  };

  constructor
  (
    private router: Router, 
    private authService: AuthService,
  ) {}
  
  ngOnInit( ): void { }

  buildForm() {}

  register() 
  {
  
    this.authService.register
    (
        this.newUser.cpf,
        this.newUser.username,
        this.newUser.password,
        this.newUser.role,
    ).subscribe();

    
    this.router.navigate(['/login']);
  }
}
