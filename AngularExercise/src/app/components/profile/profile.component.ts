import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  userInfo = [
    {name: "Mantu"},
    {email: "xaydacadic@gmail.com"},
    {address: "1234 Angel Grove"}
  ];

  show: boolean = false;
  buttonName: any = 'Show';


  constructor() { }

  ngOnInit() {
  }

  toggle() {
    this.show = !this.show;
    if (this.show)
      this.buttonName = "Hide";
    else
      this.buttonName = "Show";
  }
}
