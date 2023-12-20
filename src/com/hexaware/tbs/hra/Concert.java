package com.hexaware.tbs.hra;

import java.time.LocalDate;
import java.time.LocalTime;

class Concert extends Event {
    private String artist;
    private String type;

    public Concert(String event_name,
                   LocalDate event_date,
                   LocalTime event_time,
                   Venue venue,
                   int total_seats,
                   int available_seats,
                   double ticket_price,
                   Event.event_type e_type,
                   String artist, String type)
    {
        super(event_name, event_date, event_time, venue, total_seats, available_seats, ticket_price, e_type);
        this.artist = artist;
        this.type = type;
    }


    @Override
    public double calculate_total_revenue() {
        return (total_seats - available_seats) * ticket_price;
    }

    @Override
    public int get_booked_no_of_tickets() {
        return total_seats - available_seats;
    }

    @Override
    public void book_tickets(int num_tickets) {
        if (available_seats >= num_tickets) {
            available_seats -= num_tickets;
            System.out.println(num_tickets + " tickets booked for the concert: " + event_name);
        } else {
            System.out.println("Insufficient seats available for booking.");
        }
    }

    @Override
    public void cancel_booking(int num_tickets) {
        available_seats += num_tickets;
        System.out.println(num_tickets + " tickets canceled for the concert: " + event_name);
    }

    @Override
    public boolean display_event_details() {
        System.out.println("Concert: " + event_name);
        System.out.println("Artist: " + artist);
        System.out.println("Event Date: " + event_date);
        System.out.println("Event Time: " + event_time);
        System.out.println("Venue name: " + venue.venue_name);
        System.out.println("Venue address: " + venue.address);
        System.out.println("Available Seats: " + available_seats);
        return true;
    }

    @Override
    public int get_available_no_of_tickets() {
        return available_seats;
    }
}