import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {UserInfoService} from "../../services/user-info.service";
import {UserInfoModel} from "../../models/user-info.model";
import {UserConnectionModel} from "../../models/user-connection.model";
import {UserConnectionService} from "../../services/user-connection.service";
import {RequestsComponent} from "../requests/requests.component";

@Component({
  selector: 'app-connections',
  templateUrl: './connections.component.html',
  styleUrls: ['./connections.component.scss'],
})
export class ConnectionsComponent implements OnInit {
  userConnections ?: UserConnectionModel[] = [];
  currentPageIdx = 1;
  @ViewChild('removable') private removableElement ?: ElementRef;

  constructor(private userInfoService: UserInfoService, private userConnectionService: UserConnectionService) { }

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
    let userStr = localStorage.getItem("user");
    // @ts-ignore
    let loggedInUser: UserInfoModel = JSON.parse(userStr)
    console.log(this.removableElement?.nativeElement)
    this.userConnectionService.rejectConnection(id, loggedInUser?.id).subscribe(resp => {
      this.userConnections?.forEach(userConnection => {
        if (resp.body?.connection?.id === userConnection?.connection?.id && resp.body?.status === "REJECTED") {
          this.removableElement?.nativeElement.getElementsByClassName(`removable-${userConnection?.connection?.id}`)[0].parentElement.remove()
        }
      })
    })
  }

  blockConnection(id ?: string) {
    let userStr = localStorage.getItem("user");
    // @ts-ignore
    let loggedInUser: UserInfoModel = JSON.parse(userStr)
    console.log(this.removableElement?.nativeElement)
    this.userConnectionService.blockConnection(id, loggedInUser?.id).subscribe(resp => {
      this.userConnections?.forEach(userConnection => {
        if (resp.body?.connection?.id === userConnection?.connection?.id && resp.body?.status === "BLOCKED") {
          this.removableElement?.nativeElement.getElementsByClassName(`removable-${userConnection?.connection?.id}`)[0].parentElement.remove()
        }
      })
    })
  }
}
