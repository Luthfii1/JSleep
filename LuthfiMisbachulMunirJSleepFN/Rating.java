package LuthfiMisbachulMunirJSleepFN;

public class Rating
{
    private long total;
    private long count;

    public Rating()
    {
        count = 0;
    }

    public void insert(int rating)
    {
        total = total + count;
        count++;
    }
    
    public long getCount()
    {
        return count;
    }
    
    public long getTotal()
    {
        return total;
    }
    
    public double getAverage()
    {
        if (count != 0){
            return total/count;
        } 
        
        return 0;
    }
}
