package com.hexaware.tbs.association;
import java.time.LocalDate;
import java.time.LocalTime;
public class Concert extends Event {
    private String artistName;
    private String genre;

    // Default constructor
    public Concert() {
    }

    // Overloaded constructor with parameters
    public Concert(String event_name, LocalDate event_date, LocalTime event_time, Venue venue,
                   int total_seats, float ticket_price, Event.EventType event_type,
                   String artistName, String genre) {
        super(event_name, event_date, event_time, venue, total_seats, ticket_price, event_type);
        this.artistName = artistName;
        this.genre = genre;
    }

    // Getter and setter methods for artistName
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    // Getter and setter methods for genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void display_event_details() {
        super.display_event_details();
        System.out.println("Artist: " + artistName);
        System.out.println("Genre: " + genre);
    }
}
