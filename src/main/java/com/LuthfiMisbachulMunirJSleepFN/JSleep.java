package com.LuthfiMisbachulMunirJSleepFN;

import java.util.*;

import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonDBEngine;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JSleep {
   /* class Country {
        public String name;
        public int population;
        public List<String> listOfStates;
    }*/
    public static void main(String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
        /*SpringApplication.run(JSleep.class, args);
        try {
            String filepath = "C:\\Users\\luthf\\Documents\\Luthfi\\Kuliah UI\\Semesteran\\Semester 3\\PBO\\Praktikum\\Modul 1\\src\\json\\randomRoomList.json";
            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoom = filterByCity(tableRoom, "medan", 0, 5);
            filterTableRoom.forEach(room -> System.out.println(room.toString()));
        }
        catch (Throwable t){
            t.printStackTrace();
        }
        try{
            String filepath = "C:\\Users\\luthf\\Documents\\Luthfi\\Kuliah UI\\Semesteran\\Semester 3\\PBO\\Praktikum\\Modul 1\\src\\json\\jsonaccount.json.txt";
            JsonTable <Account> tableAccount = new JsonTable<>(Account.class, filepath);
            tableAccount.add(new Account("name", "email", "password"));
            tableAccount.writeJson();
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
        Account testRegex = new Account("Luthfi", "luthfimisbachul@gmail.com", "luThF199");
        Account testRegexFail =new Account("Lutfhi","luthfi-misbachul@gmail.com", "luthf199");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());
        for(int i=0; i<10; i++){
            ThreadingObject thread = new ThreadingObject("Thread " + i);
        }*/
    }

    /*public static Room createRoom(){
        Price price = new Price(10000.0, 10);
        Room room = new Room(2, "Restaurant", 35, price, Facility.AC, City.BALI, "Jl. jalan");
        return room;
    }

    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
        return Algorithm.<Room>collect(list,room -> room.price.price >= minPrice && room.price.price <= maxPrice);
    }
    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.<Room>paginate(list,page,pageSize,room -> room.accountId == accountId);
    }

    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, room -> room.city.toString().toLowerCase().contains(search.toLowerCase()));
    }*/
}