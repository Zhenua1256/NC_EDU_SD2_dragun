import { Component, OnInit } from '@angular/core';
import {HeaderService} from '../../service/header.service';
import {Router} from '@angular/router';
import {UserModel} from '../users/model/user.model';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public _loggedIn: boolean = false;
  public currentUser: UserModel = {};

  constructor(private headerService: HeaderService,
              private router: Router) { }

  ngOnInit() {
    this.headerService.getLoginSubscription().subscribe((event) => {
      this._loggedIn = event;
    });
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
  }
  public logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("currentUser");
    this.headerService.loggout();
    this.router.navigate(["/login"]);
}
}
