package com.hexaware.tbs.hra;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Event {
    static enum event_type{Movie, Sports, Concert}
    String event_name;
    Venue venue;
    LocalDate event_date;
    LocalTime event_time;
    int total_seats, available_seats;
    double ticket_price;
    event_type e_type;
    Event(){}
    Event(String event_name,
          LocalDate event_date,
          LocalTime event_time,
          Venue venue,
          int total_seats,
          int available_seats,
          double ticket_price,
          event_type e_type
    )
    {

        this.event_name = event_name;
        this.event_date = event_date;
        this.event_time = event_time;
        this.venue = venue;
        this.total_seats = total_seats;
        this.available_seats = available_seats;
        this.ticket_price = ticket_price;
        this.e_type = e_type;

    }

    String getEvent_name()
    {
        return this.event_name;
    }
    LocalDate getEvent_date()
    {
        return this.event_date;
    }
    LocalTime getEvent_time()
    {
        return this.event_time;
    }
    Venue getVenue()
    {
        return this.venue;
    }
    int getTotal_seats()
    {
        return this.total_seats;
    }
    int getAvailable_seats()
    {
        return this.available_seats;
    }
    double getTicket_price()
    {
        return this.ticket_price;
    }
    event_type getE_type()
    {
        return this.e_type;
    }


    void setEvent_name(String event_name)
    {
        this.event_name = event_name;
    }
    void setEvent_date(LocalDate event_date)
    {
        this.event_date = event_date;
    }
    void setEvent_time(LocalTime event_time)
    {
        this.event_time = event_time;
    }
    void setVenue(Venue venue)
    {
        this.venue = venue;
    }
    void setTotal_seats(int total_seats)
    {
        this.total_seats = total_seats;
    }
    void setAvailable_seats(int available_seats)
    {
        this.available_seats = available_seats;
    }
    void setTicket_price(double ticket_price)
    {
        this.ticket_price = ticket_price;
    }
    void setE_type(event_type e_type)
    {
        this.e_type = e_type;
    }

    abstract double calculate_total_revenue();
    abstract int get_booked_no_of_tickets();
    abstract void book_tickets(int num_tickets);
    abstract void cancel_booking(int num_tickets);
    public abstract boolean display_event_details();
    public abstract int get_available_no_of_tickets();
}
