package com.hexaware.tbs.interfaces;
import com.hexaware.tbs.interfaces.Venue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class EventServiceProviderImpl implements IEventServiceProvider {

    ArrayList<Event>eventlist=new ArrayList<>();
    @Override
    public Event create_event(String event_name, String date, String event_time,Venue venue, int total_seats, int available_seats, float ticket_price, String event_type) {
        Event obj=null;
        String genre, actorName, actressName, artist, artist_type, sport_name;
        String teamNames;

        Scanner sc=new Scanner(System.in);


        switch (event_type)
        {
            case "Movie":
                System.out.println("Enter the genre");
                genre=sc.nextLine();
                System.out.println("Enter actor name");
                actorName=sc.nextLine();
                System.out.println("Enter actress name");
                actressName=sc.nextLine();
                obj=new Movie(event_name, LocalDate.parse(date).toString(), LocalTime.parse(event_time).toString(), venue, total_seats, available_seats,ticket_price,event_type, genre, actorName, actressName);
                break;

            case "Concert":
                System.out.println("Enter artist name");
                artist=sc.nextLine();
                System.out.println("enter artist type");
                artist_type=sc.nextLine();
                obj=new Concert(event_name, LocalDate.parse(date).toString(), LocalTime.parse(event_time).toString(), venue, total_seats, available_seats,ticket_price, event_type, artist, artist_type);
                break;

            case "Sport":
                System.out.println("enter sport name");
                sport_name=sc.nextLine();
                System.out.println("enter teams name");
                teamNames=sc.nextLine();
                obj=new Sport(event_name, LocalDate.parse(date).toString(), LocalTime.parse(event_time).toString(), venue, total_seats, available_seats, ticket_price, event_type, sport_name, teamNames);
                break;
        }
        //System.out.println(obj);

        return obj;
    }

    @Override
    public int getAvailableNoOfTickets(Event event) {

        return event.getavailabletickets();


    }

    public static void main(String[] args) {
        EventServiceProviderImpl e = new EventServiceProviderImpl();
        Venue venue;
        String event_name;
        String date;
        String event_time;
        Scanner sc = new Scanner(System.in);
//        System.out.println("enter venue name");
//        String ven=sc.nextLine();
//        String venu=venue.setVenue_name(ven);
        int totalseats;
        int available_seats;
        float ticket_price;
        String event_type;
        String ven;
        String add;
        int eventNo;
        int availableCount;


        //Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("enter 1 for creating event");
            int n = sc.nextInt();
            switch (n) {
                case 1:

                    System.out.println("enter event name");
                    event_name = sc.next();
                    System.out.println("enter date in:YYYY-MM-DD");
                    date = sc.next();
                    System.out.println("enter time in:hh:mm");
                    event_time = sc.next();
                    System.out.println("enter venue name");
                    //System.out.println("enter venue name");
                    ven = sc.next();
                    // String venu=venue.setVenue_name(ven);
                    System.out.println("enter venue address");
                    add = sc.next();
                    System.out.println("enter total seats");
                    totalseats = sc.nextInt();
                    System.out.println("enter available seats:In starting totalseats=availableseats");
                    available_seats = sc.nextInt();
                    System.out.println("enter ticket price");
                    ticket_price = sc.nextFloat();
                    System.out.println("enter event type");
                    event_type = sc.next();
                    e.eventlist.add(e.create_event(event_name, date, event_time, new Venue(ven, add), totalseats, available_seats, ticket_price, event_type));
                    System.out.println("Event added succesfully");
                    for (int i = 0; i < e.eventlist.size(); i++) {
                        System.out.println("Event: " + (i + 1));
                        e.eventlist.get(i).display_event_details();
                    }
                    if (e.eventlist.size() > 0) {
                        System.out.print("Input event number from list to check availability: ");
                        eventNo = sc.nextInt();
                        availableCount = e.getAvailableNoOfTickets(e.eventlist.get(eventNo - 1));
                        System.out.println("Available seats: " + availableCount);
                        System.out.println("****************************************************************");
                        //e.getAvailableNoOfTickets();
                        break;
                        //totalseats
                    }


            }

        }
    }
}
