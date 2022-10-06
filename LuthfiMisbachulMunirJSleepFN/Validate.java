package LuthfiMisbachulMunirJSleepFN;
import java.util.ArrayList;

/**
 * Write a description of class Validate here.
 *
 * @author Luthfi Misbachul Munir
 * @version 04 October 2022
 */
public class Validate{
    public static ArrayList filter(Price[] list, int value, boolean less) {
        ArrayList result = new ArrayList<Price>();
        for (Price p: list) {
            if (less == true){
                if (p.price <= value){
                    result.add(p.price);
                }
            } else{
                if(p.price > value) {
                    result.add(p.price);
                }
            }
        }
        return result;
    }
}