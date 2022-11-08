package com.LuthfiMisbachulMunirJSleepFN;

import com.LuthfiMisbachulMunirJSleepFN.dbjson.Serializable;

public class Account extends Serializable
{
    public double balance;
    public Renter renter;
    public String name;
    public String email;
    public String password;

    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    public Object write(){
        return null;
    }

    public boolean read (String a){
        return true;
    }

    public Account(String name, String email, String password)
    {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
        this.renter = null;
    }
    
    public String toString(){
        return  "\nid Pelanggan : " + id + "\nNama : " + this.name + "\nEmail : " + this.email +
                "\nPassword : " + this.password;
    }

    public boolean validate(){
        if(this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD)){
            return true;}
        return false;
    }
}
