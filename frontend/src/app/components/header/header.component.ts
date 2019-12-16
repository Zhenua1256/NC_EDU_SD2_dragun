import {Component, OnDestroy, OnInit} from '@angular/core';
import {HeaderService} from '../../service/header.service';
import {Router} from '@angular/router';
import {UserModel} from '../users/model/user.model';
import {Subject} from 'rxjs';
import { takeUntil } from "rxjs/operators";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {

  public _loggedIn: boolean = false;
  public currentUser: UserModel = {};
  private unsubscribe: Subject<void> = new Subject<void>();

  constructor(private headerService: HeaderService,
              private router: Router) { }

  ngOnInit() {
    this.headerService.getLoginSubscription().pipe(takeUntil(this.unsubscribe)).subscribe((event) => {
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

  ngOnDestroy(): void {
    this.unsubscribe.next();
    this.unsubscribe.complete();
  }
}
