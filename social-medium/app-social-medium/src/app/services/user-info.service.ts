import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserInfoModel} from "../models/user-info.model";
import {environment} from "../../environments/environment";
import {FilterModel} from "../models/filter.model";

@Injectable({
  providedIn: 'root'
})
export class UserInfoService {

  constructor(private httpClient: HttpClient) { }

  getConnectedUsers(userId: string): Observable<UserInfoModel[]> {
    return this.httpClient.get<UserInfoModel[]>(environment.SERVER_URL + "users/"+ userId +"/connections");
  }

  searchUser(filter: FilterModel): Observable<HttpResponse<UserInfoModel[]>> {
    return this.httpClient.post<UserInfoModel[]>(environment.SERVER_URL + "users/search", filter, {observe: 'response'});
  }
}
