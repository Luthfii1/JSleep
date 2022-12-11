package com.LuthfiMisbachulMunirJSleepFN;
import java.util.ArrayList;

/**
 * Write a description of class Validate here.
 *
 * @author Luthfi Misbachul Munir
 * @version 04 October 2022
 */
public class Validate {
    /**
     * Filters a list of prices based on a specified value and comparison operator.
     *
     * @param list the list of prices to be filtered
     * @param value the value to be compared to the prices in the list
     * @param less a boolean value indicating whether the comparison should be "less than or equal to" (`true`) or "greater than" (`false`)
     * @return a list of prices that meet the specified criteria
     */
    public static ArrayList filter (Price[] list, int value, boolean less){
        ArrayList filteredPrice = new ArrayList();
        if(less == true) {
            for (Price iterator : list) {
                if(iterator.price <= value){
                    filteredPrice.add(iterator.price);
                }
            }
        }
        else{
            for (Price iterator : list) {
                if(iterator.price > value){
                    filteredPrice.add(iterator.price);
                }
            }
        }
        return filteredPrice;
    }
}