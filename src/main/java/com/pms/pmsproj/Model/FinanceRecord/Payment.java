package com.pms.pmsproj.Model.FinanceRecord;

public class Payment extends FinanceRecord{
    public String paymentID = "";
    public Double amount = 0.00;
    public String payeeID = "";
    public String paymentType = "";

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPayeeID() {
        return payeeID;
    }

    public void setPayeeID(String payeeID) {
        this.payeeID = payeeID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString(){
        return String.format("Payment ID:%s\nAmount: %s\nPayment Type:%s\nPayee ID:%s\n",this.paymentID,this.amount,this.paymentType,this.payeeID);
    }

}
