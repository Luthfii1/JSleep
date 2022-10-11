package LuthfiMisbachulMunirJSleepFN;

public class Renter extends Serializable
{
    public int phoneNumber = 0;
    public String address;
    public String username;
    
    public Renter(int id, String username, int phoneNumber)
    {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    
    public Renter(String username)
    {
        super();
        this.username = username;
    }
    
    public Renter(String username, String address)
    {
        super();
        this.username = username;
        this.address = address;
    }
    
    public Renter(String username, int phoneNumber, String address)
    {
        super();
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /* INI HARUSNYA GA KEPAKE
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }*/
}
