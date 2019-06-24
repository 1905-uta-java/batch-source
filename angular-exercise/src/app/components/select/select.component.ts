import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animals: string[] = ['dog', 'cat', 'chicken', 'fish'];
  colors: string[] = ['blue', 'green', 'yellow', 'red'];
  days: string[] = ['Saturday', 'Tuesday', 'Thursday', 'Friday'];

  aIsChosen: boolean = false
  cIsChosen: boolean = false
  dIsChosen: boolean = false

  constructor() { }

  ngOnInit() {
  }


  selected(choice) {
    this.aIsChosen = false;
    this.cIsChosen = false;
    this.dIsChosen = false;
    if (choice === 1) {
      this.aIsChosen = true;
      console.log("Success");
    }
    if(choice === 2) {
      this.cIsChosen = true;
      console.log("Success");
    }
    if(choice === 3) {
      this.dIsChosen = true;
      console.log("Success");
    }
  }

}
