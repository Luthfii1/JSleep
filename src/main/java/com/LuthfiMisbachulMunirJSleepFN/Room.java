package com.LuthfiMisbachulMunirJSleepFN;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.Serializable;

import java.util.*;

/**
 * @author Luthfi Misbachul Munir
 * @version 29 September 2022
 */

public class Room extends Serializable
{
    public int size;
    public String name;
    public int accountId;
    public Facility facility;
    public BedType bedType;
    public Price price;
    public String address;
    public City city;
    public ArrayList<Date> booked;

    public Room(int accountId, String name, int size, int price, Facility facility, City city, String address){
        super();
        this.name = name;
        this.size = size;
        this.price = price;
        this.city = city;
        this.facility = facility;
        this.address = address;
        this.bedType = BedType.SINGLE;
        this.accountId = accountId;
        this.booked = new ArrayList<Date>();
    }
    public String toString(){
        return "Id : " + id
                + "\n" + "Name : "
                + name + "\n" + "Size : "
                + size + "\n" + "Price : "
                + price.price +"\n" + "Facility : "
                + facility + "\n" + "City : "
                + city + "\n" + "Address : "
                + address
                + "\n";
    }
    public Object write(){
        return null;
    }
    public boolean read(String A){
        return false;
    }
}

/*public class Room extends Serializable
{
    public int size;
    public int accountId;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked = new ArrayList<Date>();

    public Object write(){
        return null;
    }

    public boolean read (String a){
        return true;
    }

    public Room(int accountId, String name, int size, Price price,
                Facility facility, City city, String address)
    {
        super();
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.bedType = bedType.SINGLE;
    }
    
    public String toString(){
        return  "\nid Pelanggan : " + id + "\nNama : " + this.name + "\nSize : " + this.size + 
                "\nHarga : " + this.price + "\nFasilitas : " + this.facility + "\nKota : " + 
                this.city + "\nAlamat : " + this.address;
    }
}*/
