import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  showorhide: string = "Hide!"
  visibility: boolean = true;
  users = [{
    username:'MckiDees',
    name:'Ronald McDonald',
    email:'happymeals@mcdonalds.com'
  }, {
    username:'DaKing',
    name:'Burger King',
    email:'whoopinwhopper@burgerking.com'
  }, {
    username:'RedHeadedStepChild',
    name:'Wendys',
    email:'wendys@wendys.com'
  }]
  constructor() { }

  ngOnInit() {
  }

  changeVisibility(event){
    let vis = event.target.innerHTML
    if(vis === "Hide!"){
      this.visibility = false;
      this.showorhide = "Show!"
    } else {
      this.visibility = true;
      this.showorhide = "Hide!"
    }
  }
}
