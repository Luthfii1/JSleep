package LuthfiMisbachulMunirJSleepFN;

import java.util.*;
import java.lang.Math;
import java.sql.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.*;

public class JSleep {

    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static void main (String[] args){
        String filepath = "C:\\Users\\luthf\\Documents\\Luthfi\\Kuliah UI\\Semesteran\\Semester 3\\PBO\\Praktikum\\Modul 1\\src\\Modul 6\\city.json";
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            Country input = gson.fromJson(br, Country.class);
            System.out.println("name: " + input.name);
            System.out.println("population: " + input.population);
            System.out.println("states: ");
            input.listOfStates.forEach(states -> System.out.println(states));;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    /*public static void main(String[] args){
        ArrayList<Room> Rooms = new ArrayList<Room>();
        for (int i =0;i<5 ;i++){
            Rooms.add(i, JSleep.createRoom());
            System.out.println(Rooms.get(i).toString());
        }
    }

    public static Room createRoom(){
        Price price = new Price(100000.0,5);
        Room room = new Room("Restaurant",30,price,Facility.AC,City.JAKARTA,"Jl.Medan");
        return room;
    }*/
}

