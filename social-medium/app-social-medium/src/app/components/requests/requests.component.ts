import { Component, OnInit } from '@angular/core';
import {UserInfoModel} from "../../models/user-info.model";
import {UserInfoService} from "../../services/user-info.service";
import {UserConnectionService} from "../../services/user-connection.service";

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.scss']
})
export class RequestsComponent implements OnInit {

  requests ?: UserInfoModel[];
  currentPageIdx = 1;
  constructor(private userInfoService: UserInfoService, private userConnectionService: UserConnectionService) { }

  ngOnInit(): void {

    let userStr = localStorage.getItem("user");
    // @ts-ignore
    let loggedInUser: UserInfoModel = JSON.parse(userStr)
    this.userInfoService.getConnectionRequests(loggedInUser?.id, this.currentPageIdx)
      .subscribe(value => {
        this.requests = value;
      })

  }

  acceptConnectionRequest(idToAccept?: string) {
    let userStr = localStorage.getItem("user");
    // @ts-ignore
    let loggedInUser: UserInfoModel = JSON.parse(userStr)
    this.userConnectionService.accept(idToAccept, loggedInUser?.id)
  }

  blockConnectionRequest(id ?: string) {

  }

  ignoreConnectionRequest(id?: string) {

  }
}
