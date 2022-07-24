import { Component, OnInit } from '@angular/core';
import {UserInfoModel} from "../../models/user-info.model";
import {UserInfoService} from "../../services/user-info.service";

@Component({
  selector: 'app-browser-users',
  templateUrl: './browser-users.component.html',
  styleUrls: ['./browser-users.component.scss']
})
export class BrowserUsersComponent implements OnInit {

  globalUsers ?: UserInfoModel[];
  currentPageIdx = 1;
  constructor(private userInfoService: UserInfoService) { }

  ngOnInit(): void {
    let userStr = localStorage.getItem("user");
    // @ts-ignore
    let loggedInUser: UserInfoModel = JSON.parse(userStr)
    this.userInfoService.getGlobalUsers(loggedInUser?.id, this.currentPageIdx)
      .subscribe(value => {
        this.globalUsers = value;
      })
  }

  addFriend(id ?: string) {

  }
}
