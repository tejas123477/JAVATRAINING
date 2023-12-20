package com.hexaware.tbs.JDBC_ExceptionHandling.entity;

import java.time.LocalDate;
import java.time.LocalTime;

class Sports extends Event {
    private String sport_name;
    private String[] teams_name;

    Sports(String event_name,
           LocalDate event_date,
           LocalTime event_time,
           Venue venue,
           int total_seats,
           int available_seats,
           double ticket_price,
           Event.event_type e_type,
           String sport_name,
           String[] teams_name)
    {
        this.event_name = event_name;
        this.event_date = event_date;
        this.event_time = event_time;
        this.venue = venue;
        this.total_seats = total_seats;
        this.available_seats = available_seats;
        this.ticket_price = ticket_price;
        this.e_type = e_type;
        this.sport_name = sport_name;
        this.teams_name = teams_name;
    }

    // Implement abstract methods
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
            System.out.println(num_tickets + " tickets booked for the sports event: " + event_name);
        } else {
            System.out.println("Insufficient seats available for booking.");
        }
    }

    @Override
    public void cancel_booking(int num_tickets) {
        available_seats += num_tickets;
        System.out.println(num_tickets + " tickets canceled for the sports event: " + event_name);
    }

    @Override
    public boolean display_event_details() {
        System.out.println("Sports Event: " + event_name);
        System.out.println("Sport Name: " + sport_name);
        System.out.println("Teams: \n   " + teams_name[0] + "\n   " + teams_name[1]);
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