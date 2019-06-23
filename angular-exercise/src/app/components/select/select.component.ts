import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animals = ["Cat", "Dog", "Gecko", "Orangutan", "Carp"];
  colors = ["Red", "Green", "Pthylo Blue", "Violet"];
  days = ["Monday", "Tuesday", "Yesterday", "Wednesday"];

  animSel: boolean = false;
  colSel: boolean = false;
  daySel: boolean = false;

  constructor() { }

  ngOnInit() {
  }
  checkAnims() {
    this.animSel = true;
    this.colSel = false;
    this.daySel = false;
  }
  checkColor() {
    this.colSel = true;
    this.animSel = false;
    this.daySel = false;
  }
  checkDays() {
    this.daySel = true;
    this.animSel = false;
    this.colSel = false;
  }
}
