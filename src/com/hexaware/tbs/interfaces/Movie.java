package com.hexaware.tbs.interfaces;

public class Movie extends Event {
//    genre: Genre of the movie (e.g., Action, Comedy, Horror).
//            2. ActorName
//3. ActresName

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getActressName() {
        return actressName;
    }

    public void setActressName(String actressName) {
        this.actressName = actressName;
    }

    String genre;
    String actorName;

    String actressName;

    public Movie() {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "genre='" + genre + '\'' +
                ", actorName='" + actorName + '\'' +
                ", actressName='" + actressName + '\'' +
                '}';
    }

    public Movie(String event_name, String date,String event_time, Venue venue, int total_seats, int available_seats, float ticket_price, String event_type, String genre, String actorName, String actressName) {
        super(event_name, date,event_time, venue, total_seats, available_seats, ticket_price, event_type);
        this.genre = genre;
        this.actorName = actorName;
        this.actressName = actressName;
    }

    public Movie(String event_name, String date,String event_time, Venue venue, int total_seats, int available_seats, float ticket_price, String event_type) {
        super(event_name, date,event_time, venue, total_seats, available_seats, ticket_price, event_type);
    }

    public void display_event_details(){
        System.out.println("event name "+event_name);
        System.out.println("date"+date);
        System.out.println("time"+event_time);
        System.out.println("genre"+genre);
        System.out.println("actorname"+actorName);
        System.out.println("availableseats"+available_seats);
        System.out.println("total_seats"+total_seats);
    }
    public Integer getavailabletickets()
    {
        return available_seats;
    }
}
