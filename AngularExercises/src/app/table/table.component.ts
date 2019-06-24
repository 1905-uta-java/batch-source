import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  bootstrap = false;

  people = [
    {firstName: "Tom", lastName: "Smith", email: "tomsmith@gmail.com", birthday: new Date("06/01/1995")},
    {firstName: "Less", lastName: "Leece", email: "backinmyday@gmail.com", birthday: new Date("08/12/2001")},
    {firstName: "kim", lastName: "sandra", email: "randomperson@gmail.com", birthday: new Date("12/23/2000")},
    {firstName: "sally", lastName: "delware", email: "newemailwhothis@gmail.com", birthday: new Date("10/20/1990")},
    {firstName: "sam", lastName: "smith", email: "stopspam@gmail.com", birthday: new Date("01/02/1999")},
    {firstName: "Cat", lastName: "Fredrickson", email: "hatewater@gmail.com", birthday: new Date("09/09/1992")}
  ]

  toggleBootstrap(){
    if(this.bootstrap){
      this.bootstrap = false;
    }else{
      this.bootstrap = true;
    }
  }

}
