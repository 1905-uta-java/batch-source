import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private userService: UserService) { }

  users:any = [];

  ngOnInit() {
  }

  showUsers() {
    this.userService.getUser()
      .subscribe((allUsers) => {
          this.users = allUsers;
      });
  }

}
