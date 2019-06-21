import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-s-directives',
  templateUrl: './s-directives.component.html',
  styleUrls: ['./s-directives.component.css']
})
export class SDirectivesComponent implements OnInit {

  condition: boolean = true;

  cats = [];
  //   {
  //   id: 4,
  //   name: 'Fluffy'
  // },
  // {
  //   id: 6,
  //   name: 'Socks'
  // }, {
  //   id: 8,
  //   name: 'Chips'
  // },{
  //   id: 13,
  //   name: 'Jack'
  // }]


  constructor() { }

  ngOnInit() {
  }

  changeCondition(){
    this.condition = !this.condition;
  }

}
