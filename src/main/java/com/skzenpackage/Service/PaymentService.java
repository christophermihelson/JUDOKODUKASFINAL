package com.skzenpackage.Service;

import com.skzenpackage.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    Repository repository;

    public void newPaymentForSingleMemberByID(NewPayment newPayment) {
        repository.newPaymentForSingleMemberByID(newPayment);
    }

}
