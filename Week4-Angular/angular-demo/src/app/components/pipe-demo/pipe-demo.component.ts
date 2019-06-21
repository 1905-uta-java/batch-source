import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipe-demo',
  templateUrl: './pipe-demo.component.html',
  styleUrls: ['./pipe-demo.component.css']
})
export class PipeDemoComponent implements OnInit {

  str: string = "Hello World";
  num: number = 5;
  day: Date = new Date();

  strArr: string[] = ['cAT', 'DoG', 'fOx', 'RaBBIT'];
  strArr2: string[] = ['fuji-apple', 'pasta-sauce', 'cottage-cheese', 'chocolate-milk'];

  constructor() { }

  ngOnInit() {
  }

}
