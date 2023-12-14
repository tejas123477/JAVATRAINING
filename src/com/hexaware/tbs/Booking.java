package com.hexaware.tbs;

import com.hexaware.tbs.Event;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking  {

    private Event event;
    public Booking(Event event) {
        this.event = event;
    }
    // calculate_booking_cost(num_tickets): Calculate and set the total cost of the booking

    public float calculate_booking_cost(int num_tickets)
    {
        return num_tickets*event.getTicketPrice();
    }

    //cancel_booking(num_tickets): Cancel the booking and update the available seats

    public int cancel_booking(int noftickets)
    {   int updatedseats=0;
        updatedseats=event.setAvailableSeats(event.getAvailableSeats()+noftickets);
        return updatedseats;
    }

    //getAvailableNoOfTickets(): return the total available tickets
    public void avilableseats(){
        System.out.println(event.getAvailableSeats());
    }

    //getEventDetails(): return event details from the event class

    public void event_details(){
        System.out.println(event.getEventName()+" "+event.getVenueName()+" "+event.getEventDate());
    }




    public static void main(String[] args)
    {
        Event myEvent = new Event("Movies",LocalDate.of(2023,12,23),LocalTime.of(2,43,3),"harmony",100,50,60);
        Booking booking = new Booking(myEvent);
        System.out.println(booking.calculate_booking_cost(5));
        int ans= booking.cancel_booking(40);
        System.out.println(ans);
        booking.avilableseats();
        booking.event_details();




    }
}
