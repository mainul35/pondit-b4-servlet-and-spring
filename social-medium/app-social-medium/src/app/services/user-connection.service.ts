import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserInfoModel} from "../models/user-info.model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class UserConnectionService {

  constructor(private httpClient: HttpClient) { }


  connectWithUser(idToConnect?: string, id?: string): Observable<HttpResponse<UserInfoModel>> {
    return this.httpClient.post<UserInfoModel>(environment.SERVER_URL + `users/${id}/connections/request/${idToConnect}`, null, {observe: 'response'});
  }
}
