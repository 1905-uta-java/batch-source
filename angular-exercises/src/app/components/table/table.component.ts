import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  class = "table";
  people = [{
    firstname:"ronald",
    lastname:"mcdonald",
    email: "mcdonald@mcdonald.com",
    birthday:"10/10/1910"
  }, {
    firstname:"burger",
    lastname:"king",
    email:"burgerking@burgerking.com",
    birthday:"4/6/1987"
  }, {
    firstname:"wendy's",
    lastname:"wendy",
    email:"wendyception@wendy.com",
    birthday:"8/28/1998"
  }]
  constructor() { }

  ngOnInit() {
  }

  changeTable(){
    if(this.class === "table"){
      this.class = ""
    } else { this.class = "table"}
  }

}
