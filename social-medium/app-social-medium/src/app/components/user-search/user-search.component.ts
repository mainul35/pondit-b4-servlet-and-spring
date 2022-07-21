import {Component, Input, OnInit} from '@angular/core';
import {FilterModel} from "../../models/filter.model";
import {UserInfoService} from "../../services/user-info.service";

@Component({
  selector: 'app-user-search',
  templateUrl: './user-search.component.html',
  styleUrls: ['./user-search.component.scss']
})
export class UserSearchComponent implements OnInit {

  field ?: string = "Please select a type";
  value ?: string

  constructor(private userInfoService: UserInfoService) { }

  ngOnInit(): void {
  }

  selectInputType(value: string) {
    this.field = value
    console.log(this.field)
  }

  searchUser() {
    console.log(this.field)
    console.log(this.value)

    const filter = new FilterModel();
    filter.field = this.field
    filter.value = this.value
    this.userInfoService.searchUser(filter).subscribe(value1 => {
      console.log(value1)
    }, error => {
      console.error(error)
    });
  }


}
