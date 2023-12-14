package com.hexaware.tbs.interfaces;

public class Event {



    public Event(String event_name, String date,String event_time, Venue venue, int total_seats, int available_seats, float ticket_price, String event_type) {
        this.event_name = event_name;
        this.date = date;
        this.venue = venue;
        this.total_seats = total_seats;
        this.available_seats = available_seats;
        this.ticket_price = ticket_price;
        this.event_type = event_type;
        this.event_time=event_time;
    }
    String event_name;


    @Override
    public String toString() {
        return "Event{" +
                "event_name='" + event_name + '\'' +
                ", event_time='" + event_time + '\'' +
                ", date='" + date + '\'' +
                ", venue=" + venue +
                ", total_seats=" + total_seats +
                ", available_seats=" + available_seats +
                ", ticket_price=" + ticket_price +
                ", event_type='" + event_type + '\'' +
                '}';
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    String event_time;

    String date;
    Venue venue;
    int total_seats;
    int available_seats;
    float ticket_price;
    String event_type;

    public Event() {
    }

    public void display_event_details()
    {
        System.out.println(getEvent_name());
        System.out.println(getDate());
        System.out.println(getEvent_time());
        System.out.println(getAvailable_seats());
    }

    public Integer getavailabletickets()
    {
       return getAvailable_seats();
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public int getTotal_seats() {
        return total_seats;
    }

    public void setTotal_seats(int total_seats) {
        this.total_seats = total_seats;
    }

    public int getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(int available_seats) {
        this.available_seats = available_seats;
    }

    public float getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(float ticket_price) {
        this.ticket_price = ticket_price;
    }

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }
}
