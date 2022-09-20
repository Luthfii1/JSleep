package LuthfiMisbachulMunirJSleepFN;

public class Rating
{
    private long total;
    private long count;

    public Rating()
    {
        this.total = 0;
        this.count = 0;
    }

    public void insert(int rating)
    {
        this.total = rating;
        //Tanya ini
        this.count = this.count + 1;
    }
    
    public long getCount()
    {
        return this.count;
    }
    
    public long getTotal()
    {
        return this.total;
    }
    
    public double getAverage()
    {
        if (this.count != 0){
            return this.total/this.count;
        } 
        
        return 0;
    }
}
