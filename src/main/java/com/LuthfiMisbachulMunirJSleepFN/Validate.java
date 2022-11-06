package com.LuthfiMisbachulMunirJSleepFN;
import java.util.ArrayList;

/**
 * Write a description of class Validate here.
 *
 * @author Luthfi Misbachul Munir
 * @version 04 October 2022
 */
public class Validate {
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