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

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  submitLogin() {
    console.log(this.email + " " + this.password);

    this.loginService.login(this.email, this.password)
      .then((resultToken) => {

        console.log(`
        userId: ${resultToken.userId}
        isManager: ${resultToken.isManager}
        timestamp: ${resultToken.timestamp}`);

        if(resultToken.isManager && resultToken.userId && resultToken.timestamp)
          this.authToken = resultToken;
        else
          this.authToken = null;

      }).catch((reason) => {

        console.log(reason);
      });
  }
}
