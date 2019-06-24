import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {
  colorChange:string = '';
  constructor() { }

  ngOnInit() {
  }

  changeBackground(event){
    if (event.type=='mouseover'){
      this.colorChange = 'blue';
    } else if (event.type=='mouseout'){
      this.colorChange = 'gray';
    }
  }

}
