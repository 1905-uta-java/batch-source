import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  show : boolean

  people = [{
    firstname: "bob",
    lastname: "bobbert",
    email: "bob@gmail.com",
    birthday: new Date("1964-08-21")
  }, {
    firstname: "jordan",
    lastname: "cross",
    email: "jcross@gmail.com",
    birthday: new Date("1993-04-01")
  }, {
    firstname: "kyle",
    lastname: "blarney",
    email: "kyl3@gmail.com",
    birthday: new Date("1972-02-13")
  }];

  constructor() { }

  ngOnInit() {
  }

  showInfo() {
    this.show = !this.show;
  }

}
