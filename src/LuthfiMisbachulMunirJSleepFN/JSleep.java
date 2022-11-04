package LuthfiMisbachulMunirJSleepFN;

import java.util.*;
import java.lang.Math;
import java.sql.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.*;

public class JSleep {
    class Country {
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    public static void main(String[] args) {

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
        }
    }

    public static Room createRoom(){
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
    }
}

/*public class JSleep {

    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static void main (String[] args){
        Renter testRegex = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
        Renter testRegexFail = new Renter("netlab", "081", "Jalan");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());

        try{
            String filepath = "src/json/randomRoomList.json";

            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoom = filterByCity(tableRoom, "medan", 0,5);
            filterTableRoom.forEach(room-> System.out.println(room.toString()));
        }catch(Throwable t){
            t.printStackTrace();
        }
        //Test Jakarta
        *//*try{
        String filepath = "src/json/randomRoomList.json";

        JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
        List<Room> filterTableRoom = filterByCity(tableRoom, "jakarta", 0,5);
        filterTableRoom.forEach(room-> System.out.println(room.toString()));
        }catch(Throwable t){
            t.printStackTrace();
        }*//*

        //a filterByPrice jika minPrice = 0 dan maxPrice = 500000.
        *//*try{
        String filepath = "src/json/randomRoomList.json";

        JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
        List<Room> filterTableRoom = filterByPrice(tableRoom, 0, 500000);
        filterTableRoom.forEach(room-> System.out.println(room.toString()));
        }catch(Throwable t){
            t.printStackTrace();
        }*//*

        //filterByPrice jika minPrice = 100000 dan maxPrice = 250000.
        *//*try{
        String filepath = "src/json/randomRoomList.json";
        //filterByPrice jika minPrice = 100000 dan maxPrice = 250000.
        JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
        List<Room> filterTableRoom = filterByPrice(tableRoom, 100000, 250000);
        filterTableRoom.forEach(room-> System.out.println(room.toString()));
        }catch(Throwable t){
            t.printStackTrace();
        }*//*

        //a filterByAccountId jika accountId = 1, page = 0 dan pageSize = 5.
        *//*try{
        String filepath = "src/json/randomRoomList.json";
        JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
        List<Room> filterTableRoom = filterByAccountId(tableRoom, 1, 0, 5);
        filterTableRoom.forEach(room-> System.out.println(room.toString()));
        }catch(Throwable t){
            t.printStackTrace();
        }*//*

        //filterByAccountId jika accountId = 11, page = 0 dan pageSize = 5.
        *//*try{
        String filepath = "src/json/randomRoomList.json";
        JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
        List<Room> filterTableRoom = filterByAccountId(tableRoom, 11, 0, 5);
        filterTableRoom.forEach(room-> System.out.println(room.toString()));
        }catch(Throwable t){
            t.printStackTrace();
        }*//*
    }

    public static Room createRoom(){
        Price price = new Price(10000.0, 5);
        Room room = new Room(2, "Restaurant", 30, price, Facility.AC, City.JAKARTA, "Jl.Medan");
        return room;
    }

    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){
        List<Room> found = new ArrayList<Room>();
        found = Algorithm.<Room>paginate(list, page, pageSize, a -> a.city == City.valueOf(search.toUpperCase()));
        return found;
    }

    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
        List<Room> found = new ArrayList<Room>();
        found = Algorithm.<Room>collect(list,i -> ((i.price.price >= minPrice) && (i.price.price <= maxPrice)));
        return found;
    }

    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        List<Room> found = new ArrayList<Room>();
        found = Algorithm.<Room>paginate(list, page, pageSize, i->i.accountId == accountId);
        return found;
    }
}*/

