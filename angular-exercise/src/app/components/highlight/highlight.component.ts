import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  colors : string[] = ['blue', 'green', 'yellow', 'red'];
  selectedColor : string;

  constructor() { }

  ngOnInit() {
  }

}
