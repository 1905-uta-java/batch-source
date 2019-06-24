import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  anivis: boolean = false;
  colvis: boolean = false;
  dayvis: boolean = false;
  animals: string[] = ["dog", "cat", "zebra","polar bear", "lion"];
  colors: string[] = ["red", "yellow", "blue"];
  days: string[] = ["monday", "tuesday", "wednesday", "humpday", "thursday", "friday"];
  constructor() { }

  ngOnInit() {
  }

  aniVis(){
    this.anivis = true;
  }
  colVis(){
    this.colvis = true;
  }
  dayVis(){
    this.dayvis = true;
  }
}
