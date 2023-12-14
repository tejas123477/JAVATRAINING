package com.hexaware.tbs;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {

    String eventName;
    LocalDate eventDate;
    LocalTime eventTime;

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", eventDate=" + eventDate +
                ", eventTime=" + eventTime +
                ", venueName='" + venueName + '\'' +
                ", totalSeats=" + totalSeats +
                ", availableSeats=" + availableSeats +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    String venueName;
    int totalSeats;
    int availableSeats;
    float ticketPrice;
    enum eventType {Movies,Sports,Concerts};

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
        return availableSeats;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }


    public String getEventName() {
        return eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public float calculate_total_revenue(int totalSeats,int availableSeats,float ticketPrice)
    {
        int sold=totalSeats-availableSeats;
        float revenue=sold*ticketPrice;

        return revenue;
    }
    public int getBookedNoOfTickets(int totalSeats,int availableSeats)
    {
        int nooftickets=totalSeats-availableSeats;
        return nooftickets;
    }

    public int booked_tickets(int availableSeats,int nooftickets)
    {

        int res=0;
        res=availableSeats-nooftickets;
        return res;
    }

    public int cancelBooking(int nooftickets)
    {
        setAvailableSeats(getAvailableSeats()+nooftickets);
        return getAvailableSeats();
    }

    public void display_event_details()
    {
        System.out.println(getEventName());
        System.out.println(getEventDate());
        System.out.println(getEventTime());
        System.out.println(getAvailableSeats());
    }



    Event(){
        eventName="defaultEvent";
        eventDate=LocalDate.now();
        eventTime=LocalTime.now();
        venueName="defaultVenue";
        totalSeats=0;
        availableSeats=0;
        ticketPrice=0.0f;
    }



    public Event(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName, int totalSeats, int availableSeats, float ticketPrice) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.venueName = venueName;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
    }

    public static void main(String[] args)
    {
        Event e1=new Event("Movies",LocalDate.of(2023,12,23),LocalTime.of(2,43,3),"harmony",100,50,60);
        System.out.println(e1.calculate_total_revenue(e1.getTotalSeats(), e1.getAvailableSeats(),e1.getTicketPrice()));
        System.out.println(e1.getBookedNoOfTickets(e1.getTotalSeats(),e1.getAvailableSeats()));
        e1.setAvailableSeats(100);
        int ans1=e1.booked_tickets(e1.getAvailableSeats(), 20);
        e1.setAvailableSeats(ans1);
        System.out.println("availableseats"+" "+ans1);
        int ans=e1.cancelBooking(20);
        System.out.println("available seats after cancel"+" "+ans);
        e1.display_event_details();
    }
}
