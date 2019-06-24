import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

formatted = true;

people = [{firstname : "Joe", lastname: "Blake", email : "Somewhere@gmail.com", birthday : new Date("05/23/1980")},
          {firstname : "Jim", lastname: "Smith", email : "Someplace@gmail.com", birthday : new Date("05/23/1980")},
          {firstname : "Bob", lastname: "Barker", email : "SomeLocale@gmail.com", birthday : new Date("05/23/1980")},
          {firstname : "Sal", lastname: "Vulcano", email : "Tahiti@gmail.com", birthday : new Date("05/23/1980")}
        ]

  constructor() { }

  ngOnInit() {
  }

}
