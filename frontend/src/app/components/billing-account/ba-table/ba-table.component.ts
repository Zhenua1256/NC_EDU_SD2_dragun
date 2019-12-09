import { Component, OnInit } from '@angular/core';
import {BillingAccountModel} from '../model/billing-account.model';
import {Subscription} from 'rxjs';
import {BillingAccountService} from '../../../service/Billing-Account-Service';
import {UserModel} from '../../users/model/user.model';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-ba-table',
  templateUrl: './ba-table.component.html',
  styleUrls: ['./ba-table.component.css']
})
export class BaTableComponent implements OnInit {
  public billingAccounts: BillingAccountModel[] = [];
  public  selectBa: BillingAccountModel;
  public amount: number;
  private subscriptions: Subscription[] = [];
  public currentUser: UserModel = {};
  closeResult: string;

  constructor(private billingAccountService: BillingAccountService,
              private modalService: NgbModal) { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    this.loadBillingAccounts();
  }
  open(content, billingAccount) {
    this.selectBa = billingAccount;
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = result;
      this.refill(this.selectBa.id);
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }
  private loadBillingAccounts(): void {
    this.subscriptions.push(this.billingAccountService.getBillingAccountUser(this.currentUser.id).subscribe(billingaccount => {
      this.billingAccounts = billingaccount as BillingAccountModel[];
    }));
  }
  public refill(id) {
    this.billingAccountService.refill( id, +this.closeResult).subscribe();
  }
}
