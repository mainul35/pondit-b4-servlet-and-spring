import { Component, OnInit } from '@angular/core';
import {UserInfoModel} from "../../models/user-info.model";
import {UserInfoService} from "../../services/user-info.service";
import {UserConnectionService} from "../../services/user-connection.service";
import {UserConnectionModel} from "../../models/user-connection.model";

@Component({
  selector: 'app-browser-users',
  templateUrl: './browser-users.component.html',
  styleUrls: ['./browser-users.component.scss']
})
export class BrowserUsersComponent implements OnInit {

  userConnections ?: UserConnectionModel[] = [];
  currentPageIdx = 1;
  constructor(private userInfoService: UserInfoService, private userConnectionService: UserConnectionService) { }

  ngOnInit(): void {
    let userStr = localStorage.getItem("user");
    // @ts-ignore
    let loggedInUser: UserInfoModel = JSON.parse(userStr)
    this.userInfoService.getGlobalUsers(loggedInUser?.id, this.currentPageIdx)
      .subscribe(userConnections => {
        this.userConnections = userConnections
      })
  }

  addFriend(idToConnect ?: string) {
    let userStr = localStorage.getItem("user");
    // @ts-ignore
    let loggedInUser: UserInfoModel = JSON.parse(userStr)
    this.userConnectionService.connectWithUser(idToConnect, loggedInUser.id).subscribe(resp => {
      this.userConnections?.forEach((userConnection) => {
        if ((userConnection.user?.id === resp.body?.user?.id && userConnection.connection?.id === resp.body?.connection?.id)
        || (userConnection.user?.id === resp.body?.connection?.id && userConnection.connection?.id === resp.body?.user?.id)) {
          userConnection.requestedById = loggedInUser.id
        }
      })
    })
  }
}
