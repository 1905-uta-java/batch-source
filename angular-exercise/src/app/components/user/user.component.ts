import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: User[] = [];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.callGet();
  }

  callGet() {
    this.userService.getUsers().then((result) => {
      this.users = result;
    }).catch((reason) => {
      console.log(reason);
    });
  }
}
