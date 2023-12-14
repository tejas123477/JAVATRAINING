package com.hexaware.tbs.abstraction;
import com.hexaware.tbs.abstraction.Event;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class BookingSystem {

    public abstract Event create_event(String event_name, String date, String time, int total_seats, double ticket_price, Event.event_type e_type, String venue);
    public abstract void display_event_details(Event event);
    public abstract double book_tickets(Event event, int num_tickets);
    public abstract void cancel_tickets(Event event, int num_tickets);
    public abstract int get_available_seats(Event event);
}
