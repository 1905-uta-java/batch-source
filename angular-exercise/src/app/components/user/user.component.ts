import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users : object

  constructor(private data: DataService ) { }

  ngOnInit() {

    this.data.getData().subscribe( data => {
      this.users = data
      console.log(this.users)
    }) 
  }

}
