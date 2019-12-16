import { Component, OnInit } from '@angular/core';
import {BillingAccountModel} from '../model/billing-account.model';
import {Subscription} from 'rxjs';
import {BillingAccountService} from '../../../service/Billing-Account-Service';
import {UserModel} from '../../users/model/user.model';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';

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

  public fillForm: FormGroup;
  closeResult: string;

  constructor(private billingAccountService: BillingAccountService,
              private modalService: NgbModal,
              private router: Router) { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem("currentUser"));
    this.fillForm = new FormGroup({
      fill: new FormControl('',
        [Validators.required, Validators.pattern(/^[0-9]+$/), Validators.min(0)])
    });
    this.loadBillingAccounts();
  }
  open(content, billingAccount) {
    this.selectBa = billingAccount;
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = result;
      this.refill(this.selectBa.id);
      window.location.reload();
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
    if (this.currentUser.role === "User") {
      this.subscriptions.push(this.billingAccountService.getBillingAccountUser(this.currentUser.id).subscribe(billingaccount => {
        this.billingAccounts = billingaccount as BillingAccountModel[];
      }));
    } else {
      this.subscriptions.push(this.billingAccountService.getBillingAccountCompany(this.currentUser.id).subscribe(billingaccount => {
        this.billingAccounts = billingaccount as BillingAccountModel[];
    }));
    }
  }
  public refill(id) {
    this.billingAccountService.refill(id, +this.closeResult).subscribe();
  }
  public deleteBillingAccount(id) {
    window.location.reload();
    this.billingAccountService.deleteBillingAccount(id).subscribe();
  }
  public createBA() {
    this.router.navigate(['/create-ba']);
  }
}
