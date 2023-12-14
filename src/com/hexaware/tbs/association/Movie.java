package com.hexaware.tbs.association;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movie extends Event {
    private String genre;
    private String actorName;
    private String actressName;

    // Default constructor
    public Movie(String movies, LocalDate localDate, LocalTime localTime, String harmony, int totalSeats, int ticketPrice, Event.EventType movie, String horror, String tejas, String isha) {
    }

    // Overloaded constructor with parameters
    public Movie(String event_name, LocalDate event_date, LocalTime event_time, Venue venue,
                 int total_seats, float ticket_price, Event.EventType event_type,
                 String genre, String actorName, String actressName) {
        super(event_name, event_date, event_time, venue, total_seats, ticket_price, event_type);
        this.genre = genre;
        this.actorName = actorName;
        this.actressName = actressName;
    }

    // Getter and setter methods for genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Getter and setter methods for actorName
    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    // Getter and setter methods for actressName
    public String getActressName() {
        return actressName;
    }

    public void setActressName(String actressName) {
        this.actressName = actressName;
    }

    @Override
    public void display_event_details() {
        super.display_event_details();
        System.out.println("Genre: " + genre);
        System.out.println("Actor: " + actorName);
        System.out.println("Actress: " + actressName);
    }
}
