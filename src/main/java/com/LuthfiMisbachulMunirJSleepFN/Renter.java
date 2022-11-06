package com.LuthfiMisbachulMunirJSleepFN;

import java.util.regex.Pattern;
public class Renter extends Serializable
{
    public static final String REGEX_NAME ="^[A-Z][A-Za-z0-9_]{4,20}$";
    public static final String REGEX_PHONE = "^[0-9]{9,12}$";
    public String username;
    public String address;
    public String phoneNumber;

    public Renter(String username, String phoneNumber, String address){
        super();
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public boolean validate(){
        if(this.username.matches(REGEX_NAME) && this.phoneNumber.matches(REGEX_PHONE)){
            return true;}
        return false;
    }
}

//BANG KO INI SALAH BANYAK DIMANA DAH?
/*import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Renter extends Serializable
{
    public String phoneNumber;
    final String REGEX_NAME = "^[A-Z][A-Za-z0-9_]{5,20}$";
    final String REGEX_PHONE = "^[0-9]{9,12}$";
    public String address;
    public String username;

    public Renter(int id, String username, int phoneNumber)
    {
        super();
        this.username = username;
        this.phoneNumber = String.valueOf(phoneNumber);
    }

    public Renter(String username)
    {
        super();
        this.username = username;
    }

    public Renter(String username, String address)
    {
        super();
        this.username = username;
        this.address = address;
    }

    public Renter(String username, String phoneNumber, String address)
    {
        super();
        this.username = username;
        this.address = address;
        this.phoneNumber = String.valueOf(phoneNumber);
    }

    public boolean validate(){
        return username.matches(REGEX_NAME) && phoneNumber.matches(REGEX_PHONE);
    }
}*/