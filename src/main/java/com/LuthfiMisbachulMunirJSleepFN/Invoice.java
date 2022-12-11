package com.LuthfiMisbachulMunirJSleepFN;
import com.LuthfiMisbachulMunirJSleepFN.dbjson.Serializable;


/**
 * Class representing an invoice for a room rental.
 *
 * @author Luthfi Misbachul Munir
 */
public class Invoice extends Serializable
{
    /** The ID of the buyer (guest). */
    public int buyerId;

    /** The ID of the renter (host). */
    public int renterId;

    /** The payment status of the invoice. */
    public PaymentStatus status;

    /** The rating of the room by the buyer. */
    public RoomRating rating;

    /**
     * Enum representing the different room ratings.
     */
    public enum RoomRating{
        /** No rating has been given. */
        NONE,

        /** The room was rated as bad. */
        BAD,

        /** The room was rated as neutral. */
        NEUTRAL,

        /** The room was rated as good. */
        GOOD
    }

    /**
     * Enum representing the different payment statuses.
     */
    public enum PaymentStatus{
        /** Payment failed. */
        FAILED,

        /** Payment is waiting to be processed. */
        WAITING,

        /** Payment was successful. */
        SUCCESS
    }

    /**
     * Constructs a new invoice with the given buyer and renter IDs.
     *
     * @param buyerId the ID of the buyer (guest)
     * @param renterId the ID of the renter (host)
     */
    protected Invoice(int buyerId, int renterId)
    {
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**
     * Constructs a new invoice with the given buyer and renter accounts.
     *
     * @param buyer the buyer (guest) account
     * @param renter the renter (host) account
     */
    public Invoice(Account buyer, Renter renter)
    {
        super();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**
     * Returns a printable string representation of this invoice.
     *
     * @return a printable string representation of this invoice
     */
    public String print()
    {
        return "\nBuyer id : " + buyerId + "\n" + "Renter id : " + renterId + "\n"
                + "Waktu penginapan: ";
    }
}