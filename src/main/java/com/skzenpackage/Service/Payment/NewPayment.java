package com.skzenpackage.Service.Payment;

import java.time.LocalDate;

public class NewPayment {

    private Long belongingUserID;
    private LocalDate paymentDate;
    private Boolean paymentStatus;

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getBelongingUserID() {
        return belongingUserID;
    }

    public void setBelongingUserID(Long belongingUserID) {
        this.belongingUserID = belongingUserID;
    }

}
