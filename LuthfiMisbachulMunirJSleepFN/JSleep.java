package LuthfiMisbachulMunirJSleepFN;

import java.util.*;
import java.lang.Math;

public class JSleep {
    /*
    public static void main (String[] args){
        Payment testRoom = new Payment (1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice (2, 2, 2, "");
        System.out.println (testRoom.print());
        System.out.println (testInvoice.print());
    }*/
    
    public static void main(String[] args){
        Payment testPayment = new Payment(2, 2, 2,2);
        System.out.println(testPayment.getTime());
        System.out.println(testPayment.getDuration());
        Price[] unfilteredArray = new Price[5];
        
        for(int i=0;i < unfilteredArray.length;i++){
            int j = 5000;
            unfilteredArray[i] = new Price((i+1)*j);
        }
        
        System.out.println("Price List");
        for(int i=0;i < unfilteredArray.length;i++){
            System.out.println(unfilteredArray[i].price);
        }

        System.out.println("Below 12000.0");
        System.out.println(Validate.filter(unfilteredArray, 12000,true));
        System.out.println("Above 10000.0");
        System.out.println(Validate.filter(unfilteredArray, 10000,false));
    }
    /*
    public static Room createRoom(){
        Price price = new Price (100000, 5);
        Room room = new Room ("hotel", 30, price, Facility.AC);
        return room;
    }*/
    
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

