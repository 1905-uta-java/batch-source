import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-question4',
  templateUrl: './question4.component.html',
  styleUrls: ['./question4.component.css']
})
export class Question4Component implements OnInit {
  tblInfo = [{
    firstName: "George", 
    lastName: "Newman", 
    email:"gnewman401@gmail.com", 
    birthdate:"19-JAN-89"
    },{
      firstName: "Jacob", 
      lastName: "Jewlers", 
      email:"jjjjjjjjewlers@gmail.com", 
      birthdate:"20-NOV-80"
    },{
      firstName: "Nathaniel", 
      lastName: "Jackson", 
      email:"natjack@gmail.com", 
      birthdate:"21-AUG-99"
    }];

  constructor() { }

  ngOnInit() {
  }

}
