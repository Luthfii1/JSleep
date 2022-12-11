package com.LuthfiMisbachulMunirJSleepFN;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class representing a payment for a room rental.
 *
 * @author [Your Name]
 */
public class Payment extends Invoice
{
    /** The date when the rental period ends. */
    public Date to;

    /** The date when the rental period starts. */
    public Date from;

    /** The ID of the room being rented. */
    public int roomId;

    /**
     * Constructs a new payment with the given buyer and renter IDs, room ID,
     * and rental period.
     *
     * @param buyerId the ID of the buyer (guest)
     * @param renterId the ID of the renter (host)
     * @param roomId the ID of the room being rented
     * @param from the date when the rental period starts
     * @param to the date when the rental period ends
     */
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(buyerId, renterId);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    /**
     * Constructs a new payment with the given buyer and renter accounts, room ID,
     * and rental period.
     *
     * @param buyer the buyer (guest) account
     * @param renter the renter (host) account
     * @param roomId the ID of the room being rented
     * @param from the date when the rental period starts
     * @param to the date when the rental period ends
     */
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(buyer, renter);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    /**
     * Returns a printable string representation of this payment.
     *
     * @return a printable string representation of this payment
     */
    public String print()
    {
        return "Id :" + this.id + " BuyerId :" + buyerId + " RenterId : " + renterId +
                " RoomId : " + roomId + " From : " + from + " To : " + to;
    }

    /**
     * Returns the ID of the room being rented.
     *
     * @return the ID of the room being rented
     */
    public int getRoomId()
    {
        return roomId;
    }

    /**
     * Makes a booking for the given rental period and room, if the room is available.
     *
     * @param from the date when the rental period starts
     * @param to the date when the rental period ends
     * @param room the room to be booked
     * @return true if the booking was successful, false otherwise
     */
    public static boolean makeBooking(Date from, Date to, Room room)
    {
        if(availability(from, to, room)){
            while (from.before(to)){
                room.booked.add(from); // Assign ke array
                Calendar tempVar = Calendar.getInstance();
                tempVar.setTime(from);
                tempVar.add(Calendar.DATE, 1); //Increment 1
                from = tempVar.getTime();
            }
            return true;
        }
        else{
            return false;
        }

    }

/**
 * Checks the availability of the given room for the given rental period.
 *
 * @param from the date when the rental period starts
 * @param to the date when the rental period ends
 * @param room the room to be checked for availability
 * @return true if the room is available for the given rental
 **/
    public static boolean availability(Date from,Date to,Room room){
        if(from.after(to) || from.equals(to)){
            return false;
        }

        for (Date i : room.booked) {
            if (from.equals(i)) {
                return false;
            } else if(from.before(i)){
                if(from.before(i) && to.after(i)){
                    return false;
                }
            }
        }
        return true;
    }
}