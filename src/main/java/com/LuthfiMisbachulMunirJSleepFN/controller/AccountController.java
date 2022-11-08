package com.LuthfiMisbachulMunirJSleepFN.controller;

import com.LuthfiMisbachulMunirJSleepFN.Account;
import com.LuthfiMisbachulMunirJSleepFN.Algorithm;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonAutowired;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonTable;
import com.LuthfiMisbachulMunirJSleepFN.Renter;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public final static String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
    public final static String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    @JsonAutowired(value = Account.class, filepath = "src/json/account.json") public static JsonTable<Account> accountTable;

    public AccountController()
    {
    }

    @GetMapping
    String index() { return "account page"; }
/*
    @GetMapping("/{id}")
    String getById(@PathVariable int id) { return "account id " + id + " not found!"; }*/

    public JsonTable<Account> getJsonTable()
    {
        return accountTable;
    }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    )
    {
        Account account = Algorithm.<Account>find(getJsonTable(), pred -> pred.email == email && pred.password == password);
        if (account != null)
        {
            return account;
        }
        return null;
    }

    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    )
    {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        boolean matchEmail = matcherEmail.find();

        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();
        if (matchEmail && matchFoundPassword && !name.isBlank()) {
            return new Account(name, email, password);
        }
        return null;
    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(
            @PathVariable int id,
            @RequestParam String username,
            @RequestParam String address,
            @RequestParam String phoneNumber
    )
    {
        Account temp = Algorithm.<Account>find(getJsonTable(), pred -> pred.id == id);
        if (temp.renter == null){
            temp.renter = new Renter(username, address, phoneNumber);
            return temp.renter;
        }
        return null;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(
            @PathVariable int id,
            @RequestParam double balance
    )
    {
        Account account = Algorithm.<Account>find((Iterator<Account>) accountTable, pred -> pred.id == id);
        if (account != null) {
            account.balance += balance;
            return true;
        }
        return false;
    }
}
