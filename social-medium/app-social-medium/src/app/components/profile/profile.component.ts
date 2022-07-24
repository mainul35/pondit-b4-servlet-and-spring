import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UserInfoModel} from "../../models/user-info.model";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  @Input()
  userProfile ?: UserInfoModel;

  constructor() { }

  ngOnInit(): void {
  }

}
