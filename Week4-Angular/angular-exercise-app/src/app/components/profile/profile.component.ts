import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user = {
    name: "Jared",
    age: "24",
    favoriteColor: "salmon",
    degree: "Biomedical Engineering"
  }

  showProfile: boolean = false;
  showHideText: string = "show";

  constructor() { }

  ngOnInit() {
  }

  onShowHideClick() {
    if(this.showProfile) {

      this.showProfile = false;
      this.showHideText = "show";

    } else {

      this.showProfile = true;
      this.showHideText = "hide";
    }
  }
}
