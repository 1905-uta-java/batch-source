import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: User[] = [];

  constructor(private userService: UserService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    
    this.userService.getUsers()
      .then((resultUsers) => {

        this.users = resultUsers;

      }).catch((reason) => {

        console.log(reason);
      });
  }
}
