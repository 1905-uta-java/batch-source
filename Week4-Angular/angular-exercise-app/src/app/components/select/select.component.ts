import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  selectedList: string[] = [];
  selectedListName: string = "";

  animals: string[] = [
    "Zebra",
    "Manta Ray",
    "Barn Owl",
    "Quokka",
    "Vampire Bat"
  ];

  colors: string[] = [
    "Red",
    "Green",
    "Blue",
    "Orange"
  ];

  days: string[] = [
    "Sunday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday"
  ];

  constructor() { }

  ngOnInit() {
  }

  selectList(listName: string) {
    switch(listName) {
      case "animals":
        this.selectedList = this.animals;
        this.selectedListName = "Animals";
        break;
      case "colors":
        this.selectedList = this.colors;
        this.selectedListName = "Colors";
        break;
      case "days":
        this.selectedList = this.days;
        this.selectedListName = "Days";
        break;
    }
  }
}
