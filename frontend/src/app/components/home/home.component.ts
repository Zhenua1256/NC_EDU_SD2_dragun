import {Component, OnInit} from '@angular/core';
import {UserService} from '../../service/User-Service';
import {CompanyService} from '../../service/Company-Service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {DataUserModel} from './model/data-user.model';
import {Router} from '@angular/router';
import {HeaderService} from '../../service/header.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  newLoginForm: FormGroup;
  newLogin: DataUserModel = new DataUserModel();

  constructor(private userService: UserService,
              private company: CompanyService,
              private  formbuilder: FormBuilder,
              private headerService: HeaderService,
              private  router: Router) {
  }

  ngOnInit(): void {
    this.newLoginForm = this.formbuilder.group({
      login: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  authorization() {
    this.newLogin.login = this.newLoginForm.controls.login.value;
    this.newLogin.password = this.newLoginForm.controls.password.value;
    this.userService.generateToken(this.newLogin).subscribe(token => {
      localStorage.setItem('token', token.token);
      this.userService.getCurrentUser().subscribe(user => {
        localStorage.setItem('currentUser', JSON.stringify(user));
        this.headerService.loggin();
        this.router.navigate(["/home"]);
      });
    }, (error) => {
      if (error.status === 401) {
        alert("Login or password isn't correct");
      }
    });
  }
}
