import { Component, OnInit } from '@angular/core';
import { shallowEqual } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  users = [
    {
    name: "Ben Ten",
    age: 10
  }, {
    name: "Jason Mills",
    age: 22
  }, {
    name: "Becky Lyn",
    age: 14
  }
  ];
  show: boolean = false;
  changeText: string = "Show";

  constructor() { }

  ngOnInit() {
  }

  reveal() {
    if(this.show === false) {
      this.show = true
      this.changeText = "Hide"
    }
    else {
      this.show = false
      this.changeText = "Show"
    }
  }

  

}
