package LuthfiMisbachulMunirJSleepFN;

public class Payment extends Invoice
{
    public String to;
    public String from;
    private int roomId;

    public Payment(int id, Account buyer, Renter renter, String time, 
                   int roomId, String from, String to)
    {
        super(id, buyer.id, renter.id, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    
    public Payment(int id, int buyerId, int renterId, String time, 
                   int roomId, String from, String to)
    {
        super(id, buyerId, renterId,time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    public String print()
    {
        return "Buyer id : " + buyerId + "\nRenter id : " + renterId +  
                "\nWaktu penginapan : " + (String)time + "\nDari pukul : " +
                from + "\nHingga pukul : " + to; 
    }
    
    public int getRoomId()
    {
        return roomId;
    }
}
