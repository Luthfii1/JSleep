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

    @JsonAutowired(value = Room.class, filepath = "src\\json\\.json")
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

    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize

    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam ArrayList<Facility> facility,
            @RequestParam City city,
            @RequestParam String address
    ){
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        if(account == null) return null;
        else{
            Room room = new Room(accountId, name, size, new Price(price), facility, city, address);
            roomTable.add(room);
            return room;
        }
    }
}