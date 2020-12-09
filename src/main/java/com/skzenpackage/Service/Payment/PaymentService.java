package com.skzenpackage.Service.Payment;

import com.skzenpackage.Repository.MemberRepo;
import com.skzenpackage.Repository.PaymentRepo;
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
