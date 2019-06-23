import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {
  
  stoile: string = "none";

  constructor() { }

  ngOnInit() {
    
  }
  highlightText(){
    this.stoile = "yellow";
  }
  unHighText(){
    this.stoile = undefined;
  }

}
