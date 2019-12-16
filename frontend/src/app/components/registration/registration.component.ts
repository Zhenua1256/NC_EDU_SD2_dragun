import {Component, OnInit} from '@angular/core';
import {UserModel} from '../users/model/user.model';
import {UserService} from '../../service/User-Service';
import {CompanyService} from '../../service/Company-Service';
import {CompanyModel} from '../company/model/company.model';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  newRegistrationCompanyForm: FormGroup;
  newRegistrationUserForm: FormGroup;

  public currentUser: UserModel = {};
  public currentCompany: CompanyModel = {};

  constructor(private userService: UserService,
              private companyService: CompanyService,
              private router: Router) {

  }

  public ngOnInit(): void {
    this.newRegistrationCompanyForm = new FormGroup({
      companyName: new FormControl('', /*[Validators.required]*/),
      directorName: new FormControl('', /*[Validators.required]*/),
      contactNumber: new FormControl('', /*[Validators.required, Validators.pattern(/^[0-9]+$/)]*/),
      legalAddress: new FormControl('', /*[Validators.required]*/),
      login: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
    this.newRegistrationUserForm = new FormGroup({
      name: new FormControl('', /*[Validators.required]*/),
      lastName: new FormControl('', /*[Validators.required]*/),
      login: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
  }
 addUser() {
   this.currentUser.name = this.newRegistrationUserForm.controls.name.value;
   this.currentUser.lastName = this.newRegistrationUserForm.controls.lastName.value;
   this.currentUser.password = this.newRegistrationUserForm.controls.password.value;
   this.currentUser.login = this.newRegistrationUserForm.controls.login.value;
   this.currentUser.role = "User";
   this.userService.addUser(this.currentUser).subscribe(() => {
     this.router.navigate(["/login"]);
   }, (error) => {
     if (error.status === 400) {
       alert("A user with this login is already registered");
     }
   });
 }
  addCompany() {
    this.currentCompany.name = this.newRegistrationCompanyForm.controls.companyName.value;
    this.currentCompany.directorName = this.newRegistrationCompanyForm.controls.directorName.value;
    this.currentCompany.password = this.newRegistrationCompanyForm.controls.password.value;
    this.currentCompany.login = this.newRegistrationCompanyForm.controls.login.value;
    this.currentCompany.legalAddres = this.newRegistrationCompanyForm.controls.legalAddress.value;
    this.currentCompany.contactNumber = this.newRegistrationCompanyForm.controls.contactNumber.value;
    this.currentCompany.role = "Company";
    this.companyService.addCompany(this.currentCompany).subscribe(() => {
      this.router.navigate(["/login"]);
    }, (error) => {
      if (error.status === 400) {
        alert("A company with this login is already registered");
      }
      });
  }
}
