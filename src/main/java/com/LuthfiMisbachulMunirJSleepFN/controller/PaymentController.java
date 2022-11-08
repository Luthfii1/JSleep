package com.LuthfiMisbachulMunirJSleepFN.controller;

import com.LuthfiMisbachulMunirJSleepFN.Account;
import com.LuthfiMisbachulMunirJSleepFN.Payment;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonAutowired;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonTable;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.Serializable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired
   (value = Account.class, filepath = "src/json/payment.json") public static JsonTable<Payment> paymentTable;

    public PaymentController() {
    }

    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to){
        return null;
    }

    @PostMapping("/{id}/submit")
    public boolean submit(int a){
        return false;
    }

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/{id}/accept")
    public boolean accept(int a){
        return false;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel(int a){
        return false;
    }
}
