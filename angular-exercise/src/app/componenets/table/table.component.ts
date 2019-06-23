import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  addForm: string = "";

  people=[{
    first:"john",
    last:"cena",
    birthday:"4/23/1977",
    email:"johncena@gmail.com"
  },{
    first:"roman",
    last:"reigns",
    birthday:"5/25/1985",
    email:"thebigdog@gmail.com"
  },{
    first:"finn",
    last:"balor",
    birthday:"7/25/1981",
    email:"thedemon@gmail.com"
  }]

  constructor() { }

  ngOnInit() {
  }
  addBootstrap(){
    if(this.addForm == "") {
      this.addForm = "table";
    } else {
      this.addForm = "";
    }
  }
}
