import {Component, OnInit} from '@angular/core';
import {CompanyService} from '../../service/Company-Service';
import {CompanyModel} from '../company/model/company.model';

@Component({
  selector: 'eudr-registration-company',
  templateUrl: './/registration-company.component.html',
  styleUrls: ['./registration-company.component.css']
})
export class RegistrationCompanyComponent implements OnInit {
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
