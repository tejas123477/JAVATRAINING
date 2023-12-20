package com.hexaware.tbs.Exception;

public class InvalidBookingIDException extends RuntimeException{
    public InvalidBookingIDException(String bookingId) {
        super("Invalid booking ID: " + bookingId);
    }
}
