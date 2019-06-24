import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
  animals = ["Cow", "Pig", "Rhino", "Irukanji", "Portuguesse Man O' War"];
  colors = ["Magenta", "Cyan", "Burn-blue", "Steel"];
  currentList : string[] = [];

  constructor() { }

  ngOnInit() {
  }

}
