package com.skzenpackage.Controller;

import com.skzenpackage.Service.NewPayment;
import com.skzenpackage.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping ("intraweb/payment")
@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping ("/newpayment")
    public void addNewPaymentSingleMember (@RequestBody NewPayment newPayment){
        paymentService.newPaymentForSingleMemberByID(newPayment);
    }



}
