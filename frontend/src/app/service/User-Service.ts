import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserModel} from '../components/users/model/user.model';
import {Injectable} from '@angular/core';

@Injectable()
export class UserService {
  constructor(private http: HttpClient) {
  }
  getUsers(): Observable<UserModel[]> {
    return this.http.get<UserModel[]>('/api/v1/');
  }
  deleteUser(userId: number): Observable<void> {
    return this.http.delete<void>('/api/v1/users/' + userId);
  }
  getUserId(id: number): Observable<UserModel> {
    return this.http.get<UserModel>('/api/v1/users/' + id);
  }
  addUser(user: UserModel): Observable<UserModel> {
    return this.http.post<UserModel>('/api/v1/users' , user) ;
  }
}
