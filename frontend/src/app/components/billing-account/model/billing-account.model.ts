export class BillingAccountModel {
  id?: number;
  balance?: number;
  userId?: string;
  companyId: string;
  cardNumber?: number;
  cvv?: number;
  cardName?: string;
}
