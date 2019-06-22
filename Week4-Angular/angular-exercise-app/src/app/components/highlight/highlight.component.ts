import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  myColor = "white";

  constructor() { }

  ngOnInit() {
  }

  onMouseOver() {
    this.myColor = "orange";
  }

  onMouseOut() {
    this.myColor = "white";
  }
}
