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
    @JsonAutowired
            (value = Payment.class, filepath = "src\\json\\payment.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,@RequestParam int renterId,
            @RequestParam int roomId, @RequestParam String from, @RequestParam String to
    ){
        Account cari = Algorithm.<Account>find(AccountController.accountTable,pred->pred.id==buyerId);
        Room cariruang = Algorithm.<Room>find(RoomController.roomTable, pred->pred.id==roomId);
        double hargaKamar = cariruang.price.price;
        System.out.println(from);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromtgl=null;
        Date totgl=null;
        try{
            fromtgl = sdf.parse(from);
            totgl = sdf.parse(to);
            System.out.println("date  "+totgl);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        long diffInMilliseconds = totgl.getTime() - fromtgl.getTime();
        long diffInDays = diffInMilliseconds / (1000 * 60 * 60 * 24);

        System.out.println(cari.toString());
        if(cari.balance>=hargaKamar * diffInDays &&Payment.availability(fromtgl, totgl, cariruang)){
            System.out.println(cari.toString());
            Payment baru = new Payment(buyerId,renterId,roomId,fromtgl,totgl);
            baru.status=Invoice.PaymentStatus.WAITING;
            Payment.makeBooking(fromtgl, totgl, cariruang);
            cari.balance-=hargaKamar * (double) diffInDays;
            //apa ngurangin jumlahnya disini?
            System.out.println("response backend: "+baru.toString());
            paymentTable.add(baru);
            return baru;
        }
        if(cari.balance<hargaKamar){
            System.out.println("gapunya duit ya");
        }
        if(!Payment.availability(fromtgl, totgl, cariruang)){
            System.out.println("kamar sudah di booking");
        }
        return null;
        //return new Payment(buyerId,renterId,roomId,fromtgl,totgl);

    }
    @PostMapping("/{id}/accept")
    public boolean accept(@RequestParam int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }
    @PostMapping("/{id}/cancel")
    public boolean cancel(@RequestParam int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.FAILED;
            Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.renterId);
            acc.balance += room.price.price;
            return true;
        }
        return false;
    }
}
