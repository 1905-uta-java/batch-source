import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userInfo={
    title: "associate",
    firstName: "bob",
    lastName: "seehofer",
  }
  hide :boolean = true;
  value:string = 'hide';
  constructor() { }

  ngOnInit() {
  }

  toggleVisibility(){
    this.hide = !this.hide;
    if(this.hide){
      this.value = 'hide';
    } else {
      this.value = 'show';
    }
  }

}
