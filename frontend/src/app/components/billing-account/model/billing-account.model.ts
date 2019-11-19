import {UserModel} from '../../users/model/user.model';

export class BillingAccountModel {
  id?: number;
  balance?: number;
  user?: UserModel;
  cardNumber?: number;
  cvv?: number;
  owner?: string;
}
