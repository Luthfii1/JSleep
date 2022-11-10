package com.LuthfiMisbachulMunirJSleepFN.controller;

import com.LuthfiMisbachulMunirJSleepFN.Account;
import com.LuthfiMisbachulMunirJSleepFN.Algorithm;
import com.LuthfiMisbachulMunirJSleepFN.Price;
import com.LuthfiMisbachulMunirJSleepFN.Voucher;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonAutowired;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher>{
    @JsonAutowired(value = Voucher.class,filepath = "src/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;


    public VoucherController() {

    }

    @Override
    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }

    @GetMapping("/{id}/canApply")
    @ResponseBody
    boolean canApply(@PathVariable int id, @RequestParam double price)
    {
        Voucher apply = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return apply.canApply(new Price(price));
    }

    @GetMapping("/getAvailable")
    @ResponseBody
    List<Voucher> getAvailable(
            @RequestParam int page,
            @RequestParam int pageSize){
        return Algorithm.paginate(voucherTable, page, pageSize, pred-> !pred.isUsed());
    }

    @GetMapping("/{id}/isUsed")
    @ResponseBody
    boolean isUsed(@PathVariable int id){
        for(Voucher each : voucherTable)
        {
            if (each.id == id) {
                return each.isUsed();
            }
        }
        return false;
    }
}
