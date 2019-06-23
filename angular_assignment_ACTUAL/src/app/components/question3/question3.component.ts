import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-question3',
  templateUrl: './question3.component.html',
  styleUrls: ['./question3.component.css']
})
export class Question3Component implements OnInit {
  animalArr = ["monkey", "platypus", "orangoutang"];
  colorArr = ["gray", "orange-purple", "gamboge"];
  dayArr = ["monday", "saturday", "friday"];

  animalClass: boolean = false;
  colorClass: boolean = false;
  dayClass: boolean = false;

  constructor() { }

  ngOnInit() {
  }

  handle(selected:string){
    if(selected == "animals"){
      this.animalClass = true;
      this.colorClass = false;
      this.dayClass = false;
    } else if (selected == 'colors'){
      this.animalClass = false;
      this.colorClass = true;
      this.dayClass = false;
    } else if (selected == 'days'){
      this.animalClass = false;
      this.colorClass = false;
      this.dayClass = true;
    }
  }

}
