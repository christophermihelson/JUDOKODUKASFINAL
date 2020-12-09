package com.skzenpackage.service.payment;

import com.skzenpackage.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    public void newPaymentForSingleMemberByID(NewPayment newPayment) {
        paymentRepo.newPaymentForSingleMemberByID(newPayment);
    }

}
