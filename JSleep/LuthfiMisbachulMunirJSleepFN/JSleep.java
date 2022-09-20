package LuthfiMisbachulMunirJSleepFN;

import java.util.*;
import java.lang.Math;

public class JSleep {
    public static void main (String[] args){
        Room bismillah = createRoom();
        System.out.println(bismillah.name);
        System.out.println(bismillah.size);
        System.out.println(bismillah.price.price);
        System.out.println(bismillah.facility);
    }
    
    public static Room createRoom(){
        Price price = new Price (100000, 5);
        Room room = new Room ("hotel", 30, price, Facility.AC);
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

