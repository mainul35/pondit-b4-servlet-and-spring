import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserInfoModel} from "../models/user-info.model";
import {environment} from "../../environments/environment";
import {FilterModel} from "../models/filter.model";
import {UserConnectionModel} from "../models/user-connection.model";

@Injectable({
  providedIn: 'root'
})
export class UserInfoService {

  constructor(private httpClient: HttpClient) { }

  getConnectedUsers(userId ?: string, currentPageIdx ?: number): Observable<UserConnectionModel[]> {
    return this.httpClient.get<UserConnectionModel[]>(environment.SERVER_URL + "users/"+ userId +"/connections?pageIdx=" + currentPageIdx + "&itemsPerPage=10");
  }

  searchUser(filter: FilterModel): Observable<HttpResponse<UserInfoModel[]>> {
    return this.httpClient.post<UserInfoModel[]>(environment.SERVER_URL + "users/search", filter, {observe: 'response'});
  }

  getConnectionRequests(id: string | undefined, currentPageIdx: number): Observable<UserConnectionModel[]> {
    return this.httpClient.get<UserConnectionModel[]>(environment.SERVER_URL + "users/"+ id +"/connections/requests?pageIdx=" + currentPageIdx + "&itemsPerPage=10");
  }

  getBlockedUsers(id: string | undefined, currentPageIdx: number): Observable<UserConnectionModel[]> {
    return this.httpClient.get<UserConnectionModel[]>(environment.SERVER_URL + "users/"+ id +"/connections/blocked?pageIdx=" + currentPageIdx + "&itemsPerPage=10");
  }

  getGlobalUsers(id: string | undefined, currentPageIdx: number): Observable<UserConnectionModel[]> {
    return this.httpClient.get<UserConnectionModel[]>(environment.SERVER_URL + "users/"+ id +"/non-connected-users?pageIdx=" + currentPageIdx + "&itemsPerPage=10");
  }
}
