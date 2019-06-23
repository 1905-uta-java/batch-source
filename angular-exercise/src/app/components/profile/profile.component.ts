import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  users = [{
    id: 1,
    name: "Jason Noone"
  },
  {
    id: 2,
    name: "Daniel Bryan"
  },
  {
    id: 3,
    name: "Brian Danielson"
  }]

  constructor() { }

  ngOnInit() {
  }


}
