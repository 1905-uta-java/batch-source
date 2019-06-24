import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  show : boolean = true;
  btnText : String = "Hide User Info";


  constructor() { }

  name : String;
  lastname : String;
  age : number;

  user = {name: "Bob", lastname: "Bobbert", age: 53};

  
  ngOnInit() {
  }
  
  showInfo() {
    this.show = !this.show;
    if (this.btnText === "Show User Info") {
      this.btnText = "Hide User Info";
    } else {
      this.btnText = "Show User Info";
    }
  }


}
