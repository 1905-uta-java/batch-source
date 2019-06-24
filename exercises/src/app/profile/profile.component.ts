import { Component, OnInit } from '@angular/core';
import { TimeoutError } from 'rxjs';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  hideInfo = false;
  btnText = "hide";

  toggleText(){
    if(this.btnText == "hide"){
      this.btnText = "show";
      this.hideInfo = true;

    }else{
      this.btnText = "hide";
      this.hideInfo = false;
    }
  }

  user = {
    firstName:"Tom",
    lastName:"Smith",
    favFood: "Chicken",
    birthday: "10/24/1995"
  }

}
