package LuthfiMisbachulMunirJSleepFN;

import java.util.*;
import java.lang.Math;
import java.sql.Date;

public class JSleep {
    /*
    public static void main (String[] args){
        Payment testRoom = new Payment (1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice (2, 2, 2, "");
        System.out.println (testRoom.print());
        System.out.println (testInvoice.print());
    }*/
    
    public static void main(String[] args){
        
        Room RoomA = JSleep.createRoom();
        Room RoomB = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start2 = Date.valueOf("2022-8-18");
        Date end2 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start2, end2,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-18");
        Date end3 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start3, end3,RoomB));
        
        // For false
        /*
        Room RoomA = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 20 hingga 15");
        Date start = Date.valueOf("2022-8-20");
        Date end = Date.valueOf("2022-8-15");
        System.out.println(Payment.makeBooking(start, end, RoomA));
         */
    }
    
    public static Room createRoom(){
        Price price = new Price (100000, 5);
        Room room = new Room (1, "hotel", 30, price, Facility.AC, City.BANDUNG, "Jl. Aja dulu");
        return room;
    }
    
    /*
    //This method return 0
    static int getHotelId (){
        return 0;
    }
    
    //This method return "hotel"
    static String getHotelName (){
        return "hotel";
    }
    
    //This method return true
    static boolean isDiscount (int num){
        return true;
    }
    
    //This method return persentase dari potongan harga
    static float getDiscountPercentage (int beforeDiscount, int afterDiscount){
        float harga, persen;
        
        if (beforeDiscount > afterDiscount){
            harga = beforeDiscount - afterDiscount;
            persen = (harga/beforeDiscount)*100;
        } else {
            persen = (float) 0.0;
        }

        return persen;
    }
    
    //This method return int
    static int getDiscountPrice (int price, float discountPercentage){
        int hargaAkhir, potongan;
        
        if(discountPercentage > 100){
            hargaAkhir = 0;
        } else {
            potongan = (price * (int)discountPercentage)/100;
            hargaAkhir = price - potongan;
        }
        
        return hargaAkhir;
    }

    //BANG GUA BARU MULAI DARI JAM 16.38 TOLONG
    static int getOriginalPrice (int discountPrice, float discountPercentage){
        return (discountPrice*100)/(100 - (int) discountPercentage);
    }

    //This method return 0
    static float getAdminFeePercentage (){
        return (float) 5/100;
    }

    static int getAdminFee (int price){
        float pinjem;
        
        pinjem = getAdminFeePercentage()*100;
        return price * (int)pinjem/100;
    }

    static int getTotalPrice (int price, int numberOfNight){
        return price*numberOfNight + (int) getAdminFee(price);
    }
    */
}

