package LuthfiMisbachulMunirJSleepFN;
import java.text.*;
import java.util.*;

public class Payment extends Invoice
{
    public Date to;
    public Date from;
    private int roomId;

    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(id, buyer.id, renter.id);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date();
    }
    
    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = new Date();
        this.to = new Date();
    }

    public static boolean makeBooking(Date from, Date to, Room room){
        if(from.after(to)){
            return false;
        }
        
        if (availability(from, to, room)){
            while(from.before(to)){
               room.booked.add(from);
               Calendar cal = Calendar.getInstance();
               cal.setTime(from);
               cal.add(Calendar.DATE, 1);
               from = cal.getTime();
            }
            return true;
        }
               
        return false;
    }
    
    public static boolean availability(Date from, Date to, Room room){
        for(Date i : room.booked){
            if(i.after(from) || i.equals(from)){
                return false;
            }
        }
        
        return true;
    }
    
    public String print()
    {
        return "Buyer id : " + buyerId + "\nRenter id : " + renterId + "\nDari pukul : " +
                from + "\nHingga pukul : " + to; 
    }
    
    public int getRoomId()
    {
        return roomId;
    }
    
    public String getTime(){
        SimpleDateFormat sdformat = new SimpleDateFormat ("dd MMMM yyyy");
        return "Formatted Date = " + sdformat.format(time.getTime());
    }
}
