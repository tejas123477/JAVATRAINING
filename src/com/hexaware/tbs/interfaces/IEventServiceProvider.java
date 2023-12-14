package com.hexaware.tbs.interfaces;

public interface IEventServiceProvider {

    //create_event(event_name: str, date:str, time:str, total_seats: int, ticket_price: float,
    //event_type: str, venu: Venu): Create a new event with the specified details and event type
    //(movie, sport or concert) and return event object.
    //• getEventDetails(): return array of event details from the event class.
    //• getAvailableNoOfTickets(): return the total available tickets.

     Event create_event(String event_name,String date,String event_time,Venue venue,int total_seats,int available_seats,float ticket_price,String event_type);

     int getAvailableNoOfTickets(Event event);
}
