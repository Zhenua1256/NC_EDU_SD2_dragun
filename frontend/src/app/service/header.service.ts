import {Observable, ReplaySubject, Subject} from 'rxjs';

export class HeaderService {
  private $login: Subject<boolean> = new ReplaySubject(1);

  public getLoginSubscription(): Observable<boolean> {
    return this.$login;
  }

  public loggin() {
    this.$login.next(true);
  }

  public loggout() {
    this.$login.next(false);
  }
}
