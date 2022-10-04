package LuthfiMisbachulMunirJSleepFN;
import java.util.Calendar;
import java.text.*;

/**
 * 
 * @author Luthfi Misbachul Munir
 * @version 29 September 2022
 */

public class Invoice extends Serializable
{
    public int buyerId;
    public int renterId;
    public Calendar time;
    public PaymentStatus status;
    public RoomRating rating;
    
    public enum RoomRating{
        NONE, BAD, NEUTRAL, GOOD
    }
    
    public enum PaymentStatus{
        FAILED, WAITING, SUCCESS
    }
    
    protected Invoice(int id, int buyerId, int renterId)
    {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = Calendar.getInstance();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    /*
    protected Invoice(int id, int buyerId, int renterId, String time)
    {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }*/
    
    public Invoice(int id, Account buyer, Renter renter)
    {
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = Calendar.getInstance();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public String print()
    {
        return "\nBuyer id : " + buyerId + "\n" + "Renter id : " + renterId + "\n" 
                + "Waktu penginapan: "; 
    }
}
