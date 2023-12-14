package com.hexaware.tbs.association;
import java.time.LocalDate;
import java.time.LocalTime;
import com.hexaware.tbs.association.Venue;

//public class Event {

    public abstract class Event {
        public enum EventType {Movie, Sports, Concert}

        private String event_name;
        private LocalDate event_date;
        private LocalTime event_time;
        private Venue venue;
        private int total_seats;
        private int available_seats;
        private float ticket_price;
        private EventType event_type;

        // Default constructor
        public Event() {
        }

        // Overloaded constructor with parameters
        public Event(String event_name, LocalDate event_date, LocalTime event_time, Venue venue,
                     int total_seats, float ticket_price, EventType event_type) {
            this.event_name = event_name;
            this.event_date = event_date;
            this.event_time = event_time;
            this.venue = venue;
            this.total_seats = total_seats;
            this.available_seats = total_seats; // Initially available seats are equal to total seats
            this.ticket_price = ticket_price;
            this.event_type = event_type;
        }

        // Getter and setter methods for event_name
        public String getEvent_name() {
            return event_name;
        }

        public void setEvent_name(String event_name) {
            this.event_name = event_name;
        }

        // Getter and setter methods for event_date
        public LocalDate getEvent_date() {
            return event_date;
        }

        public void setEvent_date(LocalDate event_date) {
            this.event_date = event_date;
        }

        // Getter and setter methods for event_time
        public LocalTime getEvent_time() {
            return event_time;
        }

        public void setEvent_time(LocalTime event_time) {
            this.event_time = event_time;
        }

        // Getter and setter methods for venue
        public Venue getVenue() {
            return venue;
        }

        public void setVenue(Venue venue) {
            this.venue = venue;
        }

        // Getter and setter methods for total_seats
        public int getTotal_seats() {
            return total_seats;
        }

        public void setTotal_seats(int total_seats) {
            this.total_seats = total_seats;
        }

        // Getter and setter methods for available_seats
        public int getAvailable_seats() {
            return available_seats;
        }

        public void setAvailable_seats(int available_seats) {
            this.available_seats = available_seats;
        }

        // Getter and setter methods for ticket_price
        public float getTicket_price() {
            return ticket_price;
        }

        public void setTicket_price(float ticket_price) {
            this.ticket_price = ticket_price;
        }

        // Getter and setter methods for event_type
        public EventType getEvent_type() {
            return event_type;
        }

        public void setEvent_type(EventType event_type) {
            this.event_type = event_type;
        }

        // Method to calculate total revenue
        public float calculate_total_revenue() {
            return ticket_price * (total_seats - available_seats);
        }

        // Method to get the total booked tickets
        public int getBookedNoOfTickets() {
            return total_seats - available_seats;
        }

        // Method to book tickets
        public void book_tickets(int num_tickets) {
            if (available_seats >= num_tickets) {
                available_seats -= num_tickets;
            } else {
                System.out.println("Sorry, the event is sold out. No available seats.");
            }
        }

        // Method to cancel booking
        public void cancel_booking(int num_tickets) {
            available_seats += num_tickets;
        }

        // Method to display event details
        public void display_event_details() {
            System.out.println("Event Name: " + event_name);
            System.out.println("Date: " + event_date);
            System.out.println("Time: " + event_time);
            //System.out.println("Venue: " + venue.get);
            System.out.println("Total Seats: " + total_seats);
            System.out.println("Available Seats: " + available_seats);
            System.out.println("Ticket Price: $" + ticket_price);
            System.out.println("Event Type: " + event_type);
        }
    }


