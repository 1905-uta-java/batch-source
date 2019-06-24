import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

color = "white";

  constructor() { }

  ngOnInit() {
  }

  changeColor()
  {
    if (this.color === "green")
    {
      this.color = "white";
    }
   else
    {
      this.color = "green";
    }
}
  }
