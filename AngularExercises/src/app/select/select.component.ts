import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  list;
  animalsArr = ["Cat","Dog","Bluejay","Mouse","Turtle","Cow"];
  colorsArr = ["Red","Blue","Green","Yellow","Purple","Orange","Cyan"];
  daysArr = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];

  setList(type:string){
    switch(type){
      case "animals": this.list=this.animalsArr;
        break;
      case "colors": this.list=this.colorsArr;
        break;
      case "days": this.list=this.daysArr;
        break;
    }
  }
}
