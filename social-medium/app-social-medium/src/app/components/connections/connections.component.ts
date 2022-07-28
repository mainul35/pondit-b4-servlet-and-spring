import {Component, Input, OnInit} from '@angular/core';
import {UserInfoService} from "../../services/user-info.service";
import {UserInfoModel} from "../../models/user-info.model";
import {UserConnectionModel} from "../../models/user-connection.model";

@Component({
  selector: 'app-connections',
  templateUrl: './connections.component.html',
  styleUrls: ['./connections.component.scss']
})
export class ConnectionsComponent implements OnInit {
  userConnections ?: UserConnectionModel[] = [];
  currentPageIdx = 1;
  constructor(private userInfoService: UserInfoService) { }

  ngOnInit(): void {

    let userStr = localStorage.getItem("user");
    // @ts-ignore
    let loggedInUser: UserInfoModel = JSON.parse(userStr)
    this.userInfoService.getConnectedUsers(loggedInUser?.id, this.currentPageIdx)
      .subscribe(value => {
        this.userConnections = value;
      })
  }

  removeConnection(id ?: string) {

  }

  blockConnection(id ?: string) {

  }
}
