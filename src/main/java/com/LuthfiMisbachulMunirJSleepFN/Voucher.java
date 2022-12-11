package com.LuthfiMisbachulMunirJSleepFN;

import com.LuthfiMisbachulMunirJSleepFN.dbjson.Serializable;

/**
 * The `Voucher` class represents a voucher that can be applied to a purchase to obtain a discount.
 *
 * @author (Your name here)
 * @version (The version number or date here)
 */
public class Voucher extends Serializable
{
    /**
     * The name of the voucher.
     */
    public String name;

    /**
     * A boolean value indicating whether the voucher has been used.
     */
    private boolean used;

    /**
     * The code of the voucher.
     */
    public int code;

    /**
     * The type of the voucher (discount or cashback).
     */
    public Type type;

    /**
     * The minimum purchase amount required to apply the voucher.
     */
    public double minimum;

    /**
     * The amount of the discount or cashback.
     */
    public double cut;

    /**
     * Constructs a `Voucher` object with the specified name, code, type, used flag, minimum purchase amount, and discount or cashback amount.
     *
     * @param name the name of the voucher
     * @param code the code of the voucher
     * @param type the type of the voucher (discount or cashback)
     * @param used a boolean value indicating whether the voucher has been used
     * @param minimum the minimum purchase amount required to apply the voucher
     * @param cut the amount of the discount or cashback
     */
    public Voucher(String name, int code, Type type, boolean used, double minimum, double cut) {
        super();
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
    }

    public boolean isUsed() {
        return used;
    }

    public boolean canApply(Price price) {
        return (price.price > this.minimum) && (!used);
    }

    public double apply(Price price) {
        this.used = true;

        if (this.type == Type.DISCOUNT) {
            return (this.cut > 100) ? 0 : price.price * (((100 - this.cut) / 100));
        }else {
            return (this.cut > price.price) ? 0 : (price.price - this.cut);
        }
    }
} 
