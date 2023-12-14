package com.hexaware.tbs;
import com.hexaware.tbs.Event;

public class Sport extends Event{

    //. sportName: Name of the game.
    //2. teamsName: (India vs Pakistan)

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Sport(String sportName, String teamName) {
        this.sportName = sportName;
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "sportName='" + sportName + '\'' +
                ", teamName='" + teamName + '\'' +
                '}';
    }

    String sportName;
    String teamName;

    public void display_sport_details(){
        System.out.println(getSportName());
        System.out.println(getTeamName());
    }

    public static void main(String[] args)
    {
        Sport s1=new Sport("cricket","india");
        s1.display_sport_details();

    }
}
