import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user = {username : "Joe", password: "Blake", adddress : "Somewhere", job : "Worker"};
  visibility = true;
  state = "hide";

  toggleVisibility()
  {
    this.visibility = !this.visibility;
    if (this.visibility)
    {
      this.state = "hide";
    }
    else
    {
      this.state = "show";
    }
  }
  constructor() { }

  ngOnInit() {
  }

}
