package com.hexaware.tbs;
import com.hexaware.tbs.Event;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{

    public Concert(String artist, String type) {
        this.artist = artist;
        this.type = type;
    }

    public Concert(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName, int totalSeats, int availableSeats, float ticketPrice, String artist, String type) {
        super(eventName, eventDate, eventTime, venueName, totalSeats, availableSeats, ticketPrice);
        this.artist = artist;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "artist='" + artist + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    String artist;
    String type;

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

    public void display_concert_details()
    {
        System.out.println(getArtist()+" "+getType());
    }

    public static void main(String[] args)
    {
        Concert c1=new Concert("BTS","Rock");
        c1.display_concert_details();

    }


}
