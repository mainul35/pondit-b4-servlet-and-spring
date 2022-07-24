import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-mutual-tabs',
  templateUrl: './mutual-tabs.component.html',
  styleUrls: ['./mutual-tabs.component.scss']
})
export class MutualTabsComponent implements OnInit {
  active = 1;

  constructor() { }

  ngOnInit(): void {
  }

}
