package com.LuthfiMisbachulMunirJSleepFN.controller;

import com.LuthfiMisbachulMunirJSleepFN.*;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonAutowired;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {


    @JsonAutowired(value = Room.class, filepath = "src\\json\\room.json")
    public static JsonTable<Room> roomTable;


    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter
            (
                    @PathVariable int id,
                    @RequestParam int page,
                    @RequestParam int pageSize
            ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam ArrayList<Facility> facility,
            @RequestParam City city,
            @RequestParam String address,
            @RequestParam BedType bedType
    ){
        System.out.println("Id: " + accountId);
        System.out.println("Name: " + name);
        System.out.println("Size: " + size);
        System.out.println("facility: " + facility);
        System.out.println("Address: " + address);
        System.out.println("Bed: " + bedType);
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        System.out.println(account == null);

        if(account == null) return null;
        else{
            Room room = new Room(accountId, name, size, new Price(price), facility, city, address, bedType);
            System.out.println(room);
            roomTable.add(room);
            return room;
        }
    }

    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }

    @GetMapping("/filterByCity")
    List<Room> filterByCity(
            @RequestParam City city
    ){
        return Algorithm.<Room>collect(getJsonTable(),kamar -> kamar.city == city);
    }

    /**
     * This method is used to filter room by Name
     * @param name name of the room that will be filtered
     * @return list of room that match the name
     * @author Luthfi
     */
    @GetMapping("/collectByName")
    List<Room> filterByName(
            @RequestParam String name
    ){
        return Algorithm.<Room>collect(getJsonTable(),kamar -> kamar.name.contains(name));
    }

    /**
     * This method is used to filter room by bed Type
     * @param bedType bed type of the room that will be filtered
     * @return list of room that match the bed type
     */
    @GetMapping("/collectByBedType")
    List<Room> filterByBedType(
            @RequestParam BedType bedType
    ){
        return Algorithm.<Room>collect(getJsonTable(),kamar -> kamar.bedType == bedType);
    }

    /**
     * This method is used to filter room by price
     * @param min minimum price
     * @param max maximum price
     * @return list of room that match the price
     * @author Luthfi
     */
    @GetMapping("/collectByPrice")
    List<Room> filterByPrice(
            @RequestParam int min,
            @RequestParam int max
    ){
        return Algorithm.<Room>collect(getJsonTable(),i -> ((i.price.price >= min) && (i.price.price <= max)));
    }

    /**
     * This method is used to collect all room
     * @return list of room that match the facility
     * @author Luthfi
     */
    @GetMapping("/collectRoom")
    List<Room> collectRoom(
    ){
        return Algorithm.<Room>collect(getJsonTable(),pred -> true);
    }
}