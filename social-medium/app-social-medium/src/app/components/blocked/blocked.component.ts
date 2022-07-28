import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {UserInfoModel} from "../../models/user-info.model";
import {UserInfoService} from "../../services/user-info.service";
import {UserConnectionModel} from "../../models/user-connection.model";
import {UserConnectionService} from "../../services/user-connection.service";

@Component({
  selector: 'app-blocked',
  templateUrl: './blocked.component.html',
  styleUrls: ['./blocked.component.scss']
})
export class BlockedComponent implements OnInit {

  blockedUserConnections ?: UserConnectionModel[];
  currentPageIdx = 1;
  @ViewChild('removable') private removableElement ?: ElementRef;

  constructor(private userInfoService: UserInfoService, private userConnectionService: UserConnectionService) { }


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
    let userStr = localStorage.getItem("user");
    // @ts-ignore
    let loggedInUser: UserInfoModel = JSON.parse(userStr)
    console.log(this.removableElement?.nativeElement)
    this.userConnectionService.unblockConnection(id, loggedInUser?.id).subscribe(resp => {
      this.blockedUserConnections?.forEach(blockedUserConnection => {
        if (resp.body?.connection?.id === blockedUserConnection?.connection?.id && resp.body?.status === "UNBLOCKED") {
          this.removableElement?.nativeElement.getElementsByClassName(`removable-${blockedUserConnection?.connection?.id}`)[0].parentElement.remove()
        }
      })
    })
  }
}
