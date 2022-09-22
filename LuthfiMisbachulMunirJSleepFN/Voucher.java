package LuthfiMisbachulMunirJSleepFN;

public class Voucher
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    public Voucher(String name, int code, Type type, double minimum, double cut)
    {
        this.type = type;
        this.cut = cut;
        this.name = name;
        this.code = code;
        this.minimum = minimum;
        this.used = used;
    }

    public boolean canApply(Price price)
    {
        this.minimum = minimum;
        this.used = used;
        if (price.price > this.minimum && this.used == false){
            return true;
        }
        return false;
    }
    
    public double apply(Price price){
        this.used = true;
        
        if(this.type == Type.DISCOUNT){
            if(this.cut > 100){
                this.cut = 100;
                return 0;
            }
            return price.price - (price.price * this.cut / 100);
        } else {
            if (this.cut > price.price){
                this.cut = price.price;
            }
            return price.price - this.cut;
        }
        
    }
    
    public boolean isUsed(){
        this.used = used;
        return this.used;
    }
}