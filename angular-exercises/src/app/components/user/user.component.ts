import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: User[] = [];

  constructor(private userServ: UserService) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers(){
    this.userServ.getPosts().subscribe((allUsers)=>{
      this.users = allUsers;
    })
  }


}
