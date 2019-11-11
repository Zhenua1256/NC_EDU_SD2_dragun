import {Component, OnInit} from '@angular/core';
import {UserService} from '../../service/User-Service';
import {UserModel} from '../users/model/user.model';

@Component({
  selector: 'eudr-registration-user',
  templateUrl: './/registration-user.component.html',
  styleUrls: ['./registration-user.component.css']
})
export class RegistrationUserComponent implements OnInit {
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
