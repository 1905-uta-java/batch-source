import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  
  peopleArray = [{
    "firstName": "Kyle",
    "lastName": "LATCHford",
    "email": "klatchford0@reddit.com",
    "dob": "7/3/2015"
  }, {
    "firstName": "Richart",
    "lastName": "Jonk",
    "email": "rjonk1@cornell.edu",
    "dob": "1/29/2013"
  }, {
    "firstName": "Kimberlyn",
    "lastName": "Dobbings",
    "email": "kdobbings2@chicagotribune.com",
    "dob": "4/11/2005"
  }, {
    "firstName": "Stearne",
    "lastName": "Verillo",
    "email": "sverillo3@booking.com",
    "dob": "12/25/2018"
  }];

  constructor() { }

  ngOnInit() {
  }

  toggleBootstrapStyle(){
    let tableElement = document.getElementById("theTable");
    tableElement.classList.toggle("table");
  }

}
