import {UserInfoModel} from "./user-info.model";

export class UserConnectionModel {
  user ?: UserInfoModel
  connection ?: UserInfoModel
  status ?: string
  requestedById ?: string
  blockedById ?: string
}
