import { Component, OnInit } from '@angular/core';
import {UserModel} from '../components/users/model/user.model';
import {UserService} from '../service/User-Service';
import {CompanyService} from '../service/Company-Service';
import {CompanyModel} from '../components/company/model/company.model';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  users: UserModel[] = [];
  company: CompanyModel[] = [];

  public currentUser: UserModel = {};
  public  currentCompany: CompanyModel = {};
  constructor(private userService: UserService, private companyService: CompanyService) {

  }

  ngOnInit(): void {

  }

  public addUser(user?: UserModel): void {

    console.log(this.currentUser);
    this.userService.addUser(this.currentUser)
      .subscribe(savedUser => {
        this.users.push(savedUser);
      });

  }
  public addCompany(company?: CompanyModel): void {

    console.log(this.currentCompany);
    this.companyService.addCompany(this.currentCompany)
      .subscribe(savedCompany => {
        this.company.push(savedCompany);
      });

  }

}
