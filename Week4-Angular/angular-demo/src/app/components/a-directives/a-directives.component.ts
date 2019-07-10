import { Component, OnInit } from '@angular/core';
import { Options } from 'selenium-webdriver/ie';

@Component({
  selector: 'app-a-directives',
  templateUrl: './a-directives.component.html',
  styleUrls: ['./a-directives.component.css']
})
export class ADirectivesComponent implements OnInit {

  isChecked: boolean = false;
  colors: string[] = ['blue','red','green'];
  formats: string[] = ['bold', 'italic', 'highlight'];
  selectedFormats: string[] = [];

  constructor() { }

  ngOnInit() {
  }

  updateFormat(event){
    this.selectedFormats = [];
    let opts = event.target.options;

    for(let opt of opts){
      if(opt.selected){
        this.selectedFormats.push(opt.text);
      }
    }
  }

}
