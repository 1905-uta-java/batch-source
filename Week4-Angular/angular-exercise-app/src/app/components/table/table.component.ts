import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})

export class TableComponent implements OnInit {

  pretty = true;

  people = [
    {
      firstName: "jasper",
      lastName: "pealing",
      email: "jpealing0@aol.com",
      birthday: new Date("6/26/1968")
    },
    {
      firstName: "marty",
      lastName: "gartside", 
      email: "mgartside1@dmoz.org",
      birthday: new Date("11/5/1974")
    },
    {
      firstName: "daphne",
      lastName: "espadater",
      email: "despadater2@google.it",
      birthday: new Date("5/11/1975")
    },
    {
      firstName: "goldy",
      lastName: "raddish",
      email: "graddish3@google.de",
      birthday: new Date("8/10/1999")
    },
    {
      firstName: "melany",
      lastName: "rabat",
      email: "mrabat4@webeden.co.uk",
      birthday: new Date("5/28/1990")
    },
    {
      firstName: "adams",
      lastName: "wand",
      email: "awand5@dailymail.co.uk",
      birthday: new Date("1/6/2018")
    },
    {
      firstName: "gayler",
      lastName: "biceno",
      email: "gbitcheno6@bloomberg.com",
      birthday: new Date("12/16/1997")
    },
    {
      firstName: "vyky",
      lastName: "jeves",
      email: "vjeves7@google.fr",
      birthday: new Date("3/9/2015")
    },
    {
      firstName: "klara",
      lastName: "sarll",
      email: "ksarll8@wikimedia.org",
      birthday: new Date("10/1/1963")
    },
    {
      firstName: "karisa",
      lastName: "codron",
      email: "kcodron9@usda.gov",
      birthday: new Date("12/8/2011")
    }
  ];

  constructor() { }

  ngOnInit() {
  }

  toggleFormat() {
    this.pretty = !this.pretty;
  }
}
