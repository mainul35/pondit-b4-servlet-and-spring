import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {UserInfoModel} from "../../models/user-info.model";
import {UserInfoService} from "../../services/user-info.service";
import {UserConnectionService} from "../../services/user-connection.service";
import {UserConnectionModel} from "../../models/user-connection.model";

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.scss']
})
export class RequestsComponent implements OnInit {

  requests ?: UserConnectionModel[] = [];
  currentPageIdx = 1;
  @ViewChild('removable') private removableElement ?: ElementRef;
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
    console.log(this.removableElement?.nativeElement)
    this.userConnectionService.accept(idToAccept, loggedInUser?.id).subscribe(resp => {
      this.requests?.forEach(request => {
        if (resp.body?.connection?.id === request?.connection?.id && resp.body?.status === "ACCEPTED") {
          this.removableElement?.nativeElement.getElementsByClassName(`removable-${request?.connection?.id}`)[0].parentElement.remove()
        }
      })
    })
  }

  blockConnectionRequest(id ?: string) {

  }

  ignoreConnectionRequest(id?: string) {

  }
}
