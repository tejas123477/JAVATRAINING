package com.hexaware.tbs.interfaces;

public class Sport extends Event {

    //o Attributes:
    //1. sportName: Name of the game.
    //2. teamsName: (India vs Pakistan)

    public Sport(String event_name, String date,String event_time, Venue venue, int total_seats, int available_seats, float ticket_price, String event_type, String sportName, String teamsName) {
        super(event_name, date,event_time, venue, total_seats, available_seats, ticket_price, event_type);
        this.sportName = sportName;
        this.teamsName = teamsName;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "sportName='" + sportName + '\'' +
                ", teamsName='" + teamsName + '\'' +
                '}';
    }

    String sportName;
    String teamsName;

    public Sport() {
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getTeamsName() {
        return teamsName;
    }

    public void setTeamsName(String teamsName) {
        this.teamsName = teamsName;
    }



}
