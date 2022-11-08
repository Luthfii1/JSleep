package com.LuthfiMisbachulMunirJSleepFN;


import com.LuthfiMisbachulMunirJSleepFN.dbjson.Serializable;

/**
 * Write a description of class Complaint here.
 *
 * @author Luthfi Misbachul Munir
 * @version 29 September 2022
 */
public class Complaint extends Serializable
{
    public String desc;
    public String date;

    /**
     * Constructor for objects of class Complaint
     */
    public Complaint(String date, String desc)
    {
        super();
        this.date = date;
        this.desc = desc;
    }

    public String toString()
    {
        return "id Laporan: " + id + "\nTanggal Laporan : " + this.date + "\nLaporan : " + this.desc;
    }
}
