package com.hexaware.tbs.association;
import java.time.LocalDateTime;
public class Booking {
    private static int nextBookingId = 1;
    private int bookingId;
    private Customer[] customers;
    private Event event;
    private int num_tickets;
    private float total_cost;
    private LocalDateTime booking_date;

    // Default constructor
    public Booking() {
        this.bookingId = getNextBookingId();
        this.booking_date = LocalDateTime.now();
    }

    // Overloaded constructor with parameters
    public Booking(Customer[] customers, Event event, int num_tickets, float total_cost) {
        this.bookingId = getNextBookingId();
        this.customers = customers;
        this.event = event;
        this.num_tickets = num_tickets;
        this.total_cost = total_cost;
        this.booking_date = LocalDateTime.now();
    }

    // Getter method for bookingId
    public int getBookingId() {
        return bookingId;
    }

    // Getter and setter methods for customers
    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    // Getter and setter methods for event
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    // Getter and setter methods for num_tickets
    public int getNum_tickets() {
        return num_tickets;
    }

    public void setNum_tickets(int num_tickets) {
        this.num_tickets = num_tickets;
    }

    // Getter and setter methods for total_cost
    public float getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(float total_cost) {
        this.total_cost = total_cost;
    }

    // Getter method for booking_date
    public LocalDateTime getBooking_date() {
        return booking_date;
    }

    // Display booking details method
    public void display_booking_details() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Booking Date: " + booking_date);
        System.out.println("Event Details:");
        event.display_event_details();
        System.out.println("Number of Tickets: " + num_tickets);
        System.out.println("Total Cost: $" + total_cost);
        System.out.println("Customer Details:");
        for (Customer customer : customers) {
            customer.display_customer_details();
        }
    }

    // Method to get the next bookingId and increment it
    private static int getNextBookingId() {
        return nextBookingId++;
    }
}
