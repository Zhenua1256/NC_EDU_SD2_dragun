import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CompanyModel} from '../components/company/model/company.model';
import {Injectable} from '@angular/core';

@Injectable()
export class CompanyService {
  constructor(private http: HttpClient) {
  }
  getCompanies(): Observable<CompanyModel[]> {
    return this.http.get<CompanyModel[]>('/api/v1/');
  }
  deleteCompany(companyId: number): Observable<void> {
    return this.http.delete<void>('/api/v1/companies/' + companyId);
  }
  getCompanyId(id: number): Observable<CompanyModel> {
    return this.http.get<CompanyModel>('/api/v1/companies/' + id);
  }
  addCompany(company: CompanyModel): Observable<CompanyModel> {
    return this.http.post<CompanyModel>('/api/v1/companies' , company) ;
  }
}
