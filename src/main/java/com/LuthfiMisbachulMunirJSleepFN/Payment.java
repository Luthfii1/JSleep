package com.LuthfiMisbachulMunirJSleepFN;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Payment extends Invoice {

    private int roomId;
    public Date from;
    public Date to;

    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to) {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to) {
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public int getRoomId() {
        return roomId;
    }

    public static boolean makeBooking(Date from,Date to,Room room){
        if(availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }

    public static boolean availability(Date from,Date to,Room room){
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        if(start.after(end) || start.equals(end)){
            return false;
        }
        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            if(room.booked.contains(date)){
                return false;
            }
        }
        return true;
    }

    public String getTime(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("'Formatted Date' = dd MMMM yyyy");
        String currTime = SDFormat.format(time.getTime());
        return currTime;
    }

    @Override
    public String print(){
        return "Payment{" +
                "roomId=" + roomId +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

}

/*
import java.text.*;
import java.util.*;

public class Payment extends Invoice
{
    public Date to;
    public Date from;
    private int roomId;

    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(id, buyer.id, renter.id);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date();
    }
    
    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date();
    }

    public static boolean makeBooking(Date from, Date to, Room room){
        if(from.after(to)){
            return false;
        }
        
        if (availability(from, to, room)){
            while(from.before(to)){
               room.booked.add(from);
               Calendar cal = Calendar.getInstance();
               cal.setTime(from);
               cal.add(Calendar.DATE, 1);
               from = cal.getTime();
            }
            return true;
        }
               
        return false;
    }
    
    public static boolean availability(Date from, Date to, Room room){
        for(Date i : room.booked){
            if(i.after(from) || i.equals(from)){
                return false;
            }
        }
        
        return true;
    }
    
    public String print()
    {
        return "Buyer id : " + buyerId + "\nRenter id : " + renterId + "\nDari pukul : " +
                from + "\nHingga pukul : " + to; 
    }
    
    public int getRoomId()
    {
        return roomId;
    }
    
    public String getTime(){
        SimpleDateFormat sdformat = new SimpleDateFormat ("dd MMMM yyyy");
        return "Formatted Date = " + sdformat.format(time.getTime());
    }
}
*/
