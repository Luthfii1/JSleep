package com.LuthfiMisbachulMunirJSleepFN.controller;

import com.LuthfiMisbachulMunirJSleepFN.*;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonAutowired;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value= Account.class,filepath = "src/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    @GetMapping
    String index() {
        return "payment page";
    }

    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) throws ParseException {
        Account account = Algorithm.<Account>find(new AccountController().getJsonTable(), pred -> pred.id == buyerId);
        Room room = Algorithm.<Room>find(new RoomController().getJsonTable(), pred -> pred.id == buyerId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);

        if(account == null) return null;
        if(room == null) return null;
        if(account.balance <= room.price.price) return null;
        if(!Payment.availability(fromDate, toDate, room)) return null;

        double price = room.price.price;
        Payment payment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
        account.balance -= price;
        payment.status = Invoice.PaymentStatus.WAITING;
        if(Payment.makeBooking(fromDate, toDate, room)){
            paymentTable.add(payment);
            return payment;
        }
        else return null;
    }

    @PostMapping("/{id}/accept")
    public boolean accept(@RequestParam int id){
        Payment payment = Algorithm.<Payment>find(getJsonTable(), pred -> pred.id == id);
        if(payment != null){
            if(payment.status == Invoice.PaymentStatus.WAITING){
                payment.status = Invoice.PaymentStatus.SUCCESS;
                return true;
            }
        }
        return false;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel(@RequestParam int id){
        Payment payment = Algorithm.<Payment>find(getJsonTable(), pred -> pred.id == id);
        if(payment != null){
            if(payment.status == Invoice.PaymentStatus.WAITING){
                payment.status = Invoice.PaymentStatus.SUCCESS;
                return true;
            }
        }
        return false;
    }

    @PostMapping("/{id}/submit")
    public boolean submit(@RequestParam int id){
        return false;
    }

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @Override
    public Payment getById(int id) {
        return Algorithm.<Payment>find(getJsonTable(), pred -> pred.id == id);
    }

    @Override
    public List<Payment> getPage(int page, int pageSize) {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}