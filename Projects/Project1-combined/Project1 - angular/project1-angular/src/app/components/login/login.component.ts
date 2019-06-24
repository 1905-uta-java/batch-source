import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  email: string;
  password: string;
  
  authToken: AuthToken;

  errorMessage: string;

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  submitLogin() {
    console.log(this.email + " " + this.password);

    this.loginService.login(this.email, this.password)
      .then((result) => {

        console.log(`
        userId: ${result.userId}
        isManager: ${result.isManager}
        timestamp: ${result.timestamp}`);

        this.authToken = result;

      }).catch((error) => {
        this.errorMessage = error.error;
        this.authToken = null;
      });
  }
}
