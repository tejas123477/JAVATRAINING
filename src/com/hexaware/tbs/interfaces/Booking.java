package com.hexaware.tbs.interfaces;

import com.hexaware.tbs.association.Customer;
import java.util.List;

public class Booking {
    //private static int nextBookingId = 1;
    //    private int bookingId;
    //    private Customer[] customers;
    //    private Event event;
    //    private int num_tickets;
    //    private float total_cost;
    //    private LocalDateTime booking_date;

    private static int lastBookingId = 0;


    // Instance variables


    public Booking(int bookingId, List<Customer> customers, Event event, int numTickets, double totalCost, String bookingDate) {
        this.bookingId = bookingId;
        this.customers = customers;
        this.event = event;
        this.numTickets = numTickets;
        this.totalCost = totalCost;
        this.bookingDate = bookingDate;
    }


    public static int getLastBookingId() {
        return lastBookingId;
    }

    public static void setLastBookingId(int lastBookingId) {
        Booking.lastBookingId = lastBookingId;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }
    private List<Customer> customers;
    private Event event;

    @Override
    public String toString() {
        return "Booking{" +
                "customers=" + customers +
                ", event=" + event +
                ", numTickets=" + numTickets +
                ", totalCost=" + totalCost +
                ", bookingDate='" + bookingDate + '\'' +
                ", bookingId=" + bookingId +
                '}';
    }

    private int numTickets;
    private double totalCost;
    private String bookingDate;
    private int bookingId;

}
