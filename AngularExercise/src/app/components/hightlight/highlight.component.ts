import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-text-hover',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighLightComponent implements OnInit {

  redText: string = "text-red";  
  
  constructor() { }

  ngOnInit() {
  }

}
