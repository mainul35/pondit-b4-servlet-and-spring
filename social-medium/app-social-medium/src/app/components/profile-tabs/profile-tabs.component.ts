import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile-tabs',
  templateUrl: './profile-tabs.component.html',
  styleUrls: ['./profile-tabs.component.scss']
})
export class ProfileTabsComponent implements OnInit {
  active = 1;

  constructor() { }

  ngOnInit(): void {
  }

}
