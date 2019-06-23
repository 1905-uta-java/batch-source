import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-question1',
  templateUrl: './question1.component.html',
  styleUrls: ['./question1.component.css']
})
export class Question1Component implements OnInit {
  hoverText:string = 'none';
  constructor() { }

  ngOnInit() {
  }

  toggleStyle(event){
    if(event.type=='mouseover'){
      this.hoverText = 'red';
    } else {
      this.hoverText = 'none';
    }
  }
}
