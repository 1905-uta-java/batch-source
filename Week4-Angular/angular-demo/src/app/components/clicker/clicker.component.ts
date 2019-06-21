import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clicker',
  templateUrl: './clicker.component.html',
  styleUrls: ['./clicker.component.css']
})
export class ClickerComponent implements OnInit {

  count: number = 0;
  counterClassVar: string = "redText";

  constructor() { }

  ngOnInit() {
  }

  increment(inc: number){
    this.count += inc;
    if(this.count%5==0){
      this.counterClassVar = "redText";
    } else {
      this.counterClassVar = "blueText";
    }
  }

}
