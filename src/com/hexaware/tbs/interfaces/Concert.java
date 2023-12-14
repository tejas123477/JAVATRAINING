package com.hexaware.tbs.interfaces;

public class Concert extends Event {
    //Attributes:
    //1. artist: Name of the performing artist or band.
    //2. type: (Theatrical, Classical, Rock, Recital)

    public Concert(String event_name, String date,String event_time, Venue venue, int total_seats, int available_seats, float ticket_price, String event_type, String artist, String type) {
        super(event_name, date,event_time, venue, total_seats, available_seats, ticket_price, event_type);
        this.artist = artist;
        this.type = type;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "artist='" + artist + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public Concert() {
    }

    String artist;
    String type;

    public void display_concert_details()
    {
        System.out.println(getArtist()+" "+getType());
    }

    public Concert(String event_name, String date,String event_time, Venue venue, int total_seats, int available_seats, float ticket_price, String event_type) {
        super(event_name, date,event_time, venue, total_seats, available_seats, ticket_price, event_type);
    }
}
