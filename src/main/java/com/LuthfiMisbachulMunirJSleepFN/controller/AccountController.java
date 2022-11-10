package com.LuthfiMisbachulMunirJSleepFN.controller;

import com.LuthfiMisbachulMunirJSleepFN.Account;
import com.LuthfiMisbachulMunirJSleepFN.Algorithm;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonAutowired;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonTable;
import com.LuthfiMisbachulMunirJSleepFN.Renter;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public final static String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public final static String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    @JsonAutowired(value=Account.class,filepath = "src/json/account.json")
    public static JsonTable<Account> accountTable;
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD) ;
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    /*TODO S*/
    public AccountController() {
    }

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        String generatedPassword = null;
        try{
            MessageDigest messdig = MessageDigest.getInstance("MD5");
            messdig.update(password.getBytes());
            byte[] bytes = messdig.digest();

            StringBuilder stringbuild = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                stringbuild.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            generatedPassword = stringbuild.toString();
        }
        catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return Algorithm.<Account>find(accountTable, temp -> (temp.email.equals(email)) && temp.password.equals(password));
    }

    @PostMapping("/register")
    public Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){
        String generatedPassword = null;
        for (Account account : accountTable){
            if(account.email.equals(email) || (name.isBlank()) || account.validate()){
                return null;
            }
        }
        try{
            MessageDigest messdig = MessageDigest.getInstance("MD5");
            messdig.update(password.getBytes());
            byte[] bytes = messdig.digest();

            StringBuilder stringbuild = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                stringbuild.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = stringbuild.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        accountTable.add(new Account(name, email, generatedPassword));
        return new Account(name, email, generatedPassword);
    }

    @PostMapping("/{id}/registerRenter")
    public Renter registerRenter(@PathVariable int id, @RequestParam String username, @RequestParam String address,
                          @RequestParam String phoneNumber ){
        for (Account account : accountTable){
            if((account.id == id) && (account.renter == null)){
                return(new Renter(username, phoneNumber, address));
            }
        }
        return null;
    }

    @PostMapping("/{id}/topUp")
    public boolean topUp(@PathVariable int id, @RequestParam double balance ){
        for(Account singleAccount : accountTable) {
            if(singleAccount.id == id) {
                singleAccount.balance += balance;
                return true;
            }
        }
        return false;
    }
}