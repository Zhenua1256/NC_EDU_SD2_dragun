import { Component, OnInit } from '@angular/core';
import {CompanyService} from '../../service/Company-Service';
import {CompanyModel} from './model/company.model';

@Component({
  selector: 'app-company',
  templateUrl: '../company-registration/registration-company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  company: CompanyModel[] = [];

  public currentCompany: CompanyModel = {};
  constructor(private companyService: CompanyService) {
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
