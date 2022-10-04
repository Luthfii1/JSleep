package LuthfiMisbachulMunirJSleepFN;
import java.util.ArrayList;

/**
 * Write a description of class Validate here.
 *
 * @author Luthfi Misbachul Munir
 * @version 04 October 2022
 */
public class Validate
{
    /**
     * Constructor for objects of class Validate
     */
    public Validate()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static ArrayList<Price> filter(Price[] list, int value, boolean less)
    {
        ArrayList<Price> val = new ArrayList<Price>();
        
        int i, size = list.length;
        for(i = 0; i<size; i++){
            if(less == true){
                if(list[i].price <= value){
                    val.add(list[i]);
                }
            } else {
                if(list[i].price > value){
                    val.add(list[i]);
                }
            }
        }
        return val;
    }
}
