package com.hexaware.tbs.abstraction;

import java.time.LocalDate;
import java.time.LocalTime;

public class Sport extends Event {

    //sportName: Name of the game.
    //2. teamsName: (India vs Pakistan

//    public Sport(String sportName, LocalDate parse, LocalTime parsed, String teamsName, int totalSeats, int seats, int ticketPrice, String event_type, String name, String[] team_names) {
//        this.sportName = sportName;
//        this.teamsName = teamsName;
//    }
private String sport_name;
    private String[] teams_name;

    Sport(String event_name,
           LocalDate event_date,
           LocalTime event_time,
           String venue_name,
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
        this.venue_name = venue_name;
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
        System.out.println("Venue: " + venue_name);
        System.out.println("Available Seats: " + available_seats);
        return true;
    }

    @Override
    public int get_available_no_of_tickets() {
        return available_seats;
    }


}
