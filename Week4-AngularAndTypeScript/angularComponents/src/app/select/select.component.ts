import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})

export class SelectComponent implements OnInit{
  animalsArray = ["armadillo", "squirrel", "mouse", "elephant"];
  colorsArray = ["allabaster", "artichoke", "candy apple red", 
              "fuchsia", "deep sky blye", "charcoal"];
  daysArray = ["Sunday", "Monday", "Tuesday", 
            "Wednesday", "Thursday", "Friday", "Saturday"];

  animalClass: boolean = false;
  colorClass: boolean = false;
  dayClass: boolean = false;

  constructor(){ }

  ngOnInit(){   
  }

  select(selected:string){
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
