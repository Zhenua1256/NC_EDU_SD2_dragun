import {UserModel} from '../../users/model/user.model';

export class BillingAccountModel {
  id?: number;
  balance?: number;
  userId?: number;
  cardNumber?: number;
  cvv?: number;
  owner?: string;
}
