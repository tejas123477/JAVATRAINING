package com.hexaware.tbs.association;
import java.time.LocalDate;
import java.time.LocalTime;
public class Sport extends Event {
    private String sportType;
    private String team1;
    private String team2;

    // Default constructor
    public Sport() {
    }

    // Overloaded constructor with parameters
    public Sport(String event_name, LocalDate event_date, LocalTime event_time, Venue venue,
                 int total_seats, float ticket_price, Event.EventType event_type,
                 String sportType, String team1, String team2) {
        super(event_name, event_date, event_time, venue, total_seats, ticket_price, event_type);
        this.sportType = sportType;
        this.team1 = team1;
        this.team2 = team2;
    }

    // Getter and setter methods for sportType
    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    // Getter and setter methods for team1
    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    // Getter and setter methods for team2
    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    @Override
    public void display_event_details() {
        super.display_event_details();
        System.out.println("Sport Type: " + sportType);
        System.out.println("Team 1: " + team1);
        System.out.println("Team 2: " + team2);
    }
}
