import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-question2',
  templateUrl: './question2.component.html',
  styleUrls: ['./question2.component.css']
})
export class Question2Component implements OnInit {
  show :boolean = true;
  value:string = 'show';
  info={
    fname: "George",
    lname: "Newman",
    phone:"(123) 456-7890",
    email: "gnewman401@gmail.com"
  }
  constructor() { }

  ngOnInit() {
  }

  showHide(){
    this.show = !this.show;
    if(this.show)
      this.value = 'show';
      else 
      this.value = 'hide';

  }

}
