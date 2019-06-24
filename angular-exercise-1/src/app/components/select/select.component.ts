import { Component, OnInit } from '@angular/core';
import { animationFrameScheduler } from 'rxjs';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  // isChecked : boolean = false;
  // selectedEntry;

  animalCount : Number = 0;
  colorCount : Number = 0;
  daysCount : Number = 0;

  animals : String[] = [];
  colors : String[] = [];
  days : String[] = [];

  
animalDisplay(){
  if (this.animalCount === 0) {
    this.animals.push("dog", "squirrel", "cow", "skunk", "badger");
    this.colors = [];
    this.days = [];
  }
  this.animalCount = 1;
  this.colorCount = 0;
  this.daysCount = 0;
}

colorDisplay(){
  if (this.colorCount === 0) {
    this.animals = [];
    this.colors.push("blue", "red", "green", "yellow", "orange");
    this.days = [];
  }
  this.animalCount = 0;
  this.colorCount = 1;
  this.daysCount = 0;
}

daysDisplay(){
  if (this.daysCount === 0) {
  this.animals = [];
  this.colors = [];
  this.days.push("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
  } 
  this.animalCount = 0;
  this.colorCount = 0;
  this.daysCount = 1;
}

  constructor() { }

  ngOnInit() {
  }

  // showInfo() {
  // if (this.isChecked = false) {
  //   this.isChecked = true;
  // }  
  // }

  // displayInfo() {
  //   console.log("Displaying?");
  //   if (this.isChecked === false){
  //     this.isChecked = true;
  //   } else {
  //     this.isChecked = false;
  //   }
  // }


  // private selectedLink: string="animal";        
  
  //   setradio(e: string): void   
  // {  
  //       this.selectedLink = e;       
  // }  
  
  //   isSelected(name: string): boolean   
  // {  
  //       if (!this.selectedLink) { // if no radio button is selected, always return false so every nothing is shown  
  //           return false;  
  // }  
  //       return (this.selectedLink === name); // if current radio button is selected, return true, else return false  
  //   }  

}
