import { Component, OnInit } from '@angular/core';
import {UserInfoModel} from "../../models/user-info.model";
import {UserInfoService} from "../../services/user-info.service";
import {UserConnectionModel} from "../../models/user-connection.model";

@Component({
  selector: 'app-blocked',
  templateUrl: './blocked.component.html',
  styleUrls: ['./blocked.component.scss']
})
export class BlockedComponent implements OnInit {

  blockedUserConnections ?: UserConnectionModel[];
  currentPageIdx = 1;
  constructor(private userInfoService: UserInfoService) { }

  ngOnInit(): void {
    let userStr = localStorage.getItem("user");
    // @ts-ignore
    let loggedInUser: UserInfoModel = JSON.parse(userStr)
    this.userInfoService.getBlockedUsers(loggedInUser?.id, this.currentPageIdx)
      .subscribe(value => {
        this.blockedUserConnections = value;
      })
  }

  unblock(id ?: string) {

  }
}
