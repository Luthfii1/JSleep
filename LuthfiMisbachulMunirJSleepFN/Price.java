package LuthfiMisbachulMunirJSleepFN;

public class Price
{
    public double rebate;
    public double price;
    public double discount;

    public Price(double price, double discount)
    {
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }
    
    public Price(double price)
    {
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }
    
    public String toString(){
        return "\nHarga Total : " + this.price + "\nDiscount : " + this.discount + "\nPotongan : " + this.rebate;
    }
    
    /*
    public Price(double price, double rebate)
    {
        this.price = price;
        this.discount = 0;
        this.rebate = rebate;
    }
    
    private double getDiscountedPrice()
    {
        if (discount > 100){
            discount = 100;
        } else if (discount == 100){
            return  0;
        } 
        return price - (price * discount / 100);
    }
    
    private double getRebatedPrice()
    {
        if(rebate > price){
            return 0.0;
        }
        return price - rebate;
    }*/
}
