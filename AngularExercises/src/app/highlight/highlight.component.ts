import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  constructor(){}

  ngOnInit() {
  }

  hover:boolean;

  hColor = '';
  color = 'red';

  onOver(){
    this.hColor = this.color;
  }

  onLeave(){
    this.hColor = '';
  }

  highlightColor(){
    return this.hColor;
  }


}
