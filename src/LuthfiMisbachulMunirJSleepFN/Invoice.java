package LuthfiMisbachulMunirJSleepFN;
import java.util.Calendar;
import java.text.*;
import java.util.Date;

/**
 * 
 * @author Luthfi Misbachul Munir
 * @version 29 September 2022
 */

public class Invoice extends Serializable
{
    public int buyerId;
    public int renterId;
    public Date time;
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
        this.time = new Date();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(int id, Account buyer, Renter renter)
    {
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = new Date();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public String print()
    {
        return "\nBuyer id : " + buyerId + "\n" + "Renter id : " + renterId + "\n" 
                + "Waktu penginapan: "; 
    }
}
