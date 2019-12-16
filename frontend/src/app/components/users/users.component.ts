import {Component, OnInit} from '@angular/core';
import {UserModel} from './model/user.model';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UserComponent implements OnInit {
  users: UserModel[] = [];

  public currentUser: UserModel = {};
  constructor() {

  }

  ngOnInit(): void {
  }
}
