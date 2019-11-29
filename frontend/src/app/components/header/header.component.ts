import { Component, OnInit } from '@angular/core';
import {HeaderService} from '../../service/header.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public _loggedIn: boolean = false;

  constructor(private headerService: HeaderService,
              private router: Router) { }

  ngOnInit() {
    this.headerService.getLoginSubscription().subscribe((event) => {
      this._loggedIn = event;
    });
  }
  public logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("currentUser");
    this.headerService.loggout();
    this.router.navigate(["/login"]);
}
}
