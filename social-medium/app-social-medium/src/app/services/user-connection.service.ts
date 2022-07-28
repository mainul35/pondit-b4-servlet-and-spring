import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserInfoModel} from "../models/user-info.model";
import {environment} from "../../environments/environment";
import {UserConnectionModel} from "../models/user-connection.model";

@Injectable({
  providedIn: 'root'
})
export class UserConnectionService {

  constructor(private httpClient: HttpClient) { }


  connectWithUser(idToConnect?: string, id?: string): Observable<HttpResponse<UserConnectionModel>> {
    return this.httpClient.post<UserConnectionModel>(environment.SERVER_URL + `users/${id}/connections/request/${idToConnect}`, null, {observe: 'response'});
  }

  accept(idToAccept ?: string, id ?: string): Observable<HttpResponse<UserConnectionModel>> {
    return this.httpClient.put<UserConnectionModel>(environment.SERVER_URL + `users/${id}/connections/accept/${idToAccept}`, null, {observe: 'response'})
  }
}
