import {Component, OnInit} from '@angular/core';
import {UserModel} from './model/user.model';
import {UserService} from '../../service/User-Service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UserComponent implements OnInit {
  users: UserModel[] = [];

  public currentUser: UserModel = {};
  constructor(private userService: UserService) {

  }

  ngOnInit(): void {
  }

  public add(user?: UserModel): void {

    console.log(this.currentUser);
    this.userService.addUser(this.currentUser)
      .subscribe(savedUser => {
        this.users.push(savedUser);
      });

  }
}
