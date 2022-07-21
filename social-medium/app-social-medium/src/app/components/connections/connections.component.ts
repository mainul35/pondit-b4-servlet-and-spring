import { Component, OnInit } from '@angular/core';
import {UserInfoService} from "../../services/user-info.service";

@Component({
  selector: 'app-connections',
  templateUrl: './connections.component.html',
  styleUrls: ['./connections.component.scss']
})
export class ConnectionsComponent implements OnInit {

  constructor(private userInfoService: UserInfoService) { }

  ngOnInit(): void {

    this.userInfoService.getConnectedUsers("")
  }

}
