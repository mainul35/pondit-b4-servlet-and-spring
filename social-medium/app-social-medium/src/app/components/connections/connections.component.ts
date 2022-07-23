import {Component, Input, OnInit} from '@angular/core';
import {UserInfoService} from "../../services/user-info.service";
import {UserInfoModel} from "../../models/user-info.model";

@Component({
  selector: 'app-connections',
  templateUrl: './connections.component.html',
  styleUrls: ['./connections.component.scss']
})
export class ConnectionsComponent implements OnInit {

  constructor(private userInfoService: UserInfoService) { }

  ngOnInit(): void {

    // @Input currentUser;

    this.userInfoService.getConnectedUsers("")
  }

}
