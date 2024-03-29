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
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z.]+\\.[a-zA-Z]+?$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    @JsonAutowired(value = Account.class,filepath = "src\\json\\account.json")
    public static JsonTable<Account> accountTable;

    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));
        final String generatedPassword = hashPassword(password);

        if (findAccount != null && generatedPassword.equals(findAccount.password)){
            return findAccount;
        }else{
            return null;
        }
    }

    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){
        Matcher matcherEmail = REGEX_PATTERN_EMAIL.matcher(email);
        boolean matchEmail = matcherEmail.find();

        Matcher matcherPassword = REGEX_PATTERN_PASSWORD.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();

        Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email.equals(email));
        System.out.println(findAccount == null);
        System.out.println(matchEmail);
        System.out.println(matchFoundPassword);

        if (findAccount == null && matchEmail && matchFoundPassword) {
            final String generatedPassword;
            generatedPassword = hashPassword(password);
            Account account = new Account(name, email, generatedPassword);
            accountTable.add(account);
            return account;
        } return null;
    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(@PathVariable int id, @RequestParam String username, @RequestParam String address,
                          @RequestParam String phoneNumber ){
        System.out.println(id);
        System.out.println(username);
        System.out.println(address);
        System.out.println(phoneNumber);
        Account temp = Algorithm.<Account>find(accountTable,pred -> pred.id == id);
        if(temp.renter == null && temp != null){
            temp.renter = new Renter(username, address, phoneNumber);
            return temp.renter;
        }
        else{
            return null;
        }
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance ){
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return true;
        }else{
            return false;
        }
    }

    String hashPassword(String password){
        String generatedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }
}