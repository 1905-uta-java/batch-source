import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  striped: boolean = true;

  benD = new Date("year");
  
  people = [
    {
      firstN: "Ben",
      lastN: "Ten",
      email: "ben@gmail.com",
      birth: new Date('December 17, 1995')
    },
    {
      firstN: "Gwen",
      lastN: "Ten",
      email: "gwen@gmail.com",
      birth: new Date('July 17, 1997')
    },
    {
      firstN: "Kevin",
      lastN: "Eleven",
      email: "kevin@gmail.com",
      birth: new Date('June 17, 1980')
    }
  ]

  constructor() { }

  ngOnInit() {
  }

  makeHtml() {
    if (this.striped === true) {
      this.striped = false;
    }
    else {
      this.striped = true;
    }
  }

}
