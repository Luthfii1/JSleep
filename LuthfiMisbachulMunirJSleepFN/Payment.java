package LuthfiMisbachulMunirJSleepFN;
import java.util.Calendar;
import java.text.*;

public class Payment extends Invoice
{
    public Calendar to;
    public Calendar from;
    private int roomId;

    public Payment(int id, Account buyer, Renter renter, int roomId)
    {
        super(id, buyer.id, renter.id);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    
    public Payment(int id, int buyerId, int renterId, int roomId)
    {
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
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
        SimpleDateFormat date = new SimpleDateFormat("'Formatted Date:' dd MMMM yyyy");
        return date.format(this.from.getTime());
    }
    
    public String getDuration(){
        SimpleDateFormat date = new SimpleDateFormat("dd MMMM yyyy");
        return date.format(this.from.getTime()) + " - " + date.format(this.to.getTime());
    }
}
