package com.LuthfiMisbachulMunirJSleepFN;

/**
 * The `Rating` class represents a rating of a product or service.
 *
 * @author Luthfi Misbachul Munir
 * @version 11 Desember 2022
 */
public class Rating
{
    /**
     * The total sum of all ratings.
     */
    private long total;

    /**
     * The number of ratings.
     */
    private long count;

    /**
     * Constructs a `Rating` object with 0 ratings.
     */
    public Rating()
    {
        count = 0;
    }

    /**
     * Inserts a rating into the `Rating` object.
     *
     * @param rating the rating to be inserted
     */
    public void insert(int rating)
    {
        total = total + count;
        count++;
    }

    /**
     * Returns the number of ratings in the `Rating` object.
     *
     * @return the number of ratings in the `Rating` object
     */
    public long getCount()
    {
        return count;
    }

    /**
     * Returns the total sum of all ratings in the `Rating` object.
     *
     * @return the total sum of all ratings in the `Rating` object
     */
    public long getTotal()
    {
        return total;
    }

    /**
     * Returns the average rating of the `Rating` object.
     *
     * @return the average rating of the `Rating` object
     */
    public double getAverage()
    {
        if (count != 0){
            return total/count;
        }

        return 0;
    }

    /**
     * Returns a string representation of the `Rating` object.
     *
     * @return a string representation of the `Rating` object
     */
    public String toString(){
        return "\nTotal : " + total + "\nCount : " + count;
    }
}