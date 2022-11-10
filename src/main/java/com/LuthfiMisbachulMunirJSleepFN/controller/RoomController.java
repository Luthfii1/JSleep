package com.LuthfiMisbachulMunirJSleepFN.controller;

import com.LuthfiMisbachulMunirJSleepFN.*;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonAutowired;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{
    @JsonAutowired(value= Room.class,filepath = "src/json/room.json")
    public static JsonTable<Room> roomTable;

    @PostMapping("/create")
    Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam Facility facility,
            @RequestParam City city,
            @RequestParam String address
            ){
        for(Account each : AccountController.accountTable) {
            if (each.id == accountId && each.renter != null){
                Room room =  new Room(accountId, name, size, price, facility, city, address);
                roomTable.add(room);
                return room;
            }
        }
        return null;
    }

    @Override
    public JsonTable<Room> getJsonTable(){
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    @ResponseBody
    List<Room> getRoomByRenter(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize){
        return Algorithm.paginate(roomTable, page, pageSize,pred->pred.accountId == id);
    }
}
