package com.KODULEHT.Controller;

import com.KODULEHT.Classes.AddMember;
import com.KODULEHT.Classes.DeleteMember;
import com.KODULEHT.Classes.FullMember;
import com.KODULEHT.Classes.NewPayment;
import com.KODULEHT.Service.MemberService;
import com.KODULEHT.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
