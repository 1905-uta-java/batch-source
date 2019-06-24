import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  class: string[] = [];
  constructor() { }

  ngOnInit() {
  }


  changeBackground(event){
    this.class = ['bgc'];
  }

  revert(event){
    this.class = [];
  }
}
