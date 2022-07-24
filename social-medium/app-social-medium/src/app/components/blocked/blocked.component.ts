import { Component, OnInit } from '@angular/core';
import {UserInfoModel} from "../../models/user-info.model";
import {UserInfoService} from "../../services/user-info.service";

@Component({
  selector: 'app-blocked',
  templateUrl: './blocked.component.html',
  styleUrls: ['./blocked.component.scss']
})
export class BlockedComponent implements OnInit {

  blockedUsers ?: UserInfoModel[];
  currentPageIdx = 1;
  constructor(private userInfoService: UserInfoService) { }

  ngOnInit(): void {
    let userStr = localStorage.getItem("user");
    // @ts-ignore
    let loggedInUser: UserInfoModel = JSON.parse(userStr)
    this.userInfoService.getBlockedUsers(loggedInUser?.id, this.currentPageIdx)
      .subscribe(value => {
        this.blockedUsers = value;
      })
  }

  unblock(id ?: string) {
    
  }
}
