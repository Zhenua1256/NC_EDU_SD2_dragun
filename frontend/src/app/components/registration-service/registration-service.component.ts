/*
import {Component, OnInit} from '@angular/core';
import {CompanyService} from '../../service/Company-Service';
import {CompanyModel} from '../company/model/company.model';

@Component({
  selector: 'app-reg-service',
  templateUrl: './/registration-service.component.html',
  styleUrls: ['./registration-service.component.css']
})
export class RegistrationServiceComponent implements OnInit {
  company: CompanyModel[] = [];

  public currentCompany: CompanyModel = {};
  constructor(private companyService: CompanyService ) {

  }

  ngOnInit(): void {

  }

  public add(company?: CompanyModel): void {

    console.log(this.currentCompany);
    this.companyService.addCompany(this.currentCompany)
      .subscribe(savedCompany => {
        this.company.push(savedCompany);
      });

  }
}
*/
