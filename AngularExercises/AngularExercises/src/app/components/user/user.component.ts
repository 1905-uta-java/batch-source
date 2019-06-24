import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  userArray : User[] = [];

  constructor(private user : UserService) 
  {
  }

  ngOnInit() 
  {
    this.getUsers();
  }

  getUsers()
  {
    this.user.getUsers().then( (returnedArrayOfUsers) =>
    {
      this.userArray = returnedArrayOfUsers;
    }).catch((reason) =>
    {
      console.log(reason);
    });
  }
}


