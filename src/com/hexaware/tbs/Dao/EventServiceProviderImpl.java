package com.hexaware.dao;

import com.hexaware.entity.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EventServiceProviderImpl implements IEventServiceProvider{
    ArrayList<Event> events = new ArrayList<>();
    @Override
    public
    Movie createEvent(String eventName, LocalDate eventDate, LocalTime eventTime, Venue venue, int totalSeats, int availableSeats, double ticketPrice, EventType eventType, String genre, String actorName, String actressName) {
        return new Movie(eventName, eventDate, eventTime,venue,totalSeats,availableSeats ,ticketPrice,eventType,genre,actorName,actressName);
    }

    @Override
    public Concert createEvent(String eventName, LocalDate eventDate, LocalTime eventTime, Venue venue, int totalSeats, int availableSeats, double ticketPrice, EventType eventType, String artist, String type) {
        return new Concert(eventName, eventDate, eventTime,venue,totalSeats,availableSeats,ticketPrice,eventType,artist,type);
    }

    @Override
    public Sports createEvent(String eventName, LocalDate eventDate, LocalTime eventTime, Venue venue, int totalSeats, int availableSeats, double ticketPrice, EventType eventType, String sportName, ArrayList<String> teamsName) {
        return new Sports(eventName, eventDate, eventTime,venue,totalSeats,availableSeats ,ticketPrice,eventType,sportName,teamsName);
    }

    @Override
    public List<String> getEventDetails(Event event) {
        List<String> eventDetails = new ArrayList<>();
        eventDetails.add(event.getEventName());
        eventDetails.add(event.getEventDate().toString());
        eventDetails.add(event.getEventTime().toString());
        eventDetails.add(event.getVenue().getVenueName());
        eventDetails.add(event.getEventType().toString());

        return eventDetails;
    }

    @Override
    public int getAvailableNoOfTickets(Event event) {
        return event.getAvailableSeats();
    }
}
