package com.hexaware.tbs.abstraction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;
//import static com.hexaware.tbs.abstraction.Event.eventType.Sports;

public class TicketBookingSystem extends BookingSystem{
    ArrayList<Event> eventList = new ArrayList<>();
    @Override
    public Event create_event(String event_name, String date, String time, int total_seats, double ticket_price, Event.event_type e_type, String venue){
        Event obj = null;
        String genre, actor_name, actress_name, artist, artist_type, sport_name;
        String[] team_names = new String[2];
        Scanner sc = new Scanner(System.in);

        switch(e_type){
            case Movie :
                System.out.print("Enter genre: ");
                genre = sc.nextLine();
                System.out.print("Enter actor name: ");
                actor_name = sc.nextLine();
                System.out.print("Enter actress name: ");
                actress_name = sc.nextLine();
                obj = new Movie(event_name, LocalDate.parse(date), LocalTime.parse(time), venue, total_seats, total_seats,ticket_price, e_type, genre, actor_name, actress_name);
                break;
            case Concert :
                System.out.println("Enter artist: ");
                artist = sc.nextLine();
                System.out.println("Enter artist type: ");
                artist_type = sc.nextLine();
                obj = new Concert(event_name, LocalDate.parse(date), LocalTime.parse(time), venue, total_seats, total_seats,ticket_price, e_type, artist, artist_type);
                break;

            case Sports :
                System.out.println("Enter sport name: ");
                sport_name = sc.nextLine();
                System.out.println("Enter team 1 name: ");
                team_names[0] = sc.nextLine();
                System.out.println("Enter team 2 name: ");
                team_names[1] = sc.nextLine();
                obj = new Sport(event_name, LocalDate.parse(date), LocalTime.parse(time), venue, total_seats, total_seats, ticket_price, e_type, sport_name, team_names);
        }
        return obj;
    }

    @Override
    public void display_event_details(Event event) {
        event.display_event_details();
    }

    @Override
    public double book_tickets(Event event, int num_tickets) {
        double cost = 0;
        if (event.getAvailable_seats() >= num_tickets) {
            cost = num_tickets * event.getTicket_price();
            event.book_tickets(num_tickets);
        } else {
            System.out.println("Insufficient seats available for booking.");
        }
        return cost;
    }
    @Override
    public void cancel_tickets(Event event, int num_tickets){
        event.cancel_booking(num_tickets);
    }
    @Override
    public int get_available_seats(Event event){
        return event.get_available_no_of_tickets();
    }

    public static void main(String[] args){
        TicketBookingSystem tbs = new TicketBookingSystem();
        Scanner sc = new Scanner(System.in);

        String event_name, venue, date, time;
        int total_seats, select, i, eventNo, bookingCount, cancelCount, availableCount;
        double ticket_price;
        Event.event_type e_type;
        int running = 0;
        while( true ) {
            System.out.println("1. Create Event.");
            System.out.println("2. Book Tickets.");
            System.out.println("3. Cancel Tickets.");
            System.out.println("4. Get Available Seats.");
            System.out.println("5. Exit.");
            System.out.print("Enter Selection: ");
            select = sc.nextInt();
            sc.nextLine();
            switch (select) {
                case 1:
                    System.out.print("Enter event name: ");
                    event_name = sc.nextLine();
                    System.out.print("Enter event date (yyyy-mm-dd): ");
                    date = sc.nextLine();
                    System.out.print("Enter event time (HH:MM): ");
                    time = sc.nextLine();
                    System.out.print("Enter venue: ");
                    venue = sc.nextLine();
                    System.out.print("Enter total seats: ");
                    total_seats = sc.nextInt();
                    System.out.print("Ticket price: ");
                    ticket_price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Event type (Movie/ Sports/ Concert): ");
                    e_type = Event.event_type.valueOf(sc.nextLine());
                    tbs.eventList.add(tbs.create_event(event_name, date, time, total_seats, ticket_price, e_type, venue));
                    System.out.println("Event added successfully.");
                    break;

                case 2:
                    System.out.println("***********************************************************");
                    for (i = 0; i < tbs.eventList.size(); i++) {
                        System.out.println("Event: " + (i + 1));
                        tbs.eventList.get(i).display_event_details();
                        System.out.println("*****************************************************");
                    }
                    if (tbs.eventList.size() > 0) {
                        System.out.print("Input event number from list for booking: ");
                        eventNo = sc.nextInt();
                        System.out.print("Enter no. of tickets: ");
                        bookingCount = sc.nextInt();
                        ticket_price = tbs.book_tickets(tbs.eventList.get(eventNo - 1), bookingCount);
                        System.out.println("Ticket price: " + ticket_price);
                        System.out.println("*********************************************************");
                        break;
                    }
                    else{
                        System.out.println("No events available! Please add event first.");
                        break;
                    }
                case 3:
                    System.out.println("*************************************************************");
                    for (i = 0; i < tbs.eventList.size(); i++) {
                        System.out.println("Event: " + (i + 1));
                        tbs.eventList.get(i).display_event_details();
                        System.out.println("***********************************************************");
                    }
                    if (tbs.eventList.size() > 0) {
                        System.out.print("Input event number from list for cancelling: ");
                        eventNo = sc.nextInt();
                        System.out.print("Enter no. of tickets: ");
                        cancelCount = sc.nextInt();
                        tbs.cancel_tickets(tbs.eventList.get(eventNo - 1), cancelCount);
                        System.out.println("************************************************************");
                        break;
                    }
                    else{
                        System.out.println("No events available! Please add event first.");
                        break;
                    }

                case 4:
                    System.out.println("******************************************************************");
                    for (i = 0; i < tbs.eventList.size(); i++) {
                        System.out.println("Event: " + (i + 1));
                        tbs.eventList.get(i).display_event_details();
                        System.out.println("****************************************************************");
                    }
                    if(tbs.eventList.size() > 0) {
                        System.out.print("Input event number from list to check availability: ");
                        eventNo = sc.nextInt();
                        availableCount = tbs.get_available_seats(tbs.eventList.get(eventNo - 1));
                        System.out.println("Available seats: " + availableCount);
                        System.out.println("****************************************************************");
                        break;
                    }
                    else{
                        System.out.println("No events available! Please add event first.");
                        break;
                    }
                case 5:
                    System.exit(0);
                    break;
                default:
                    if (running==3){
                        System.out.println("You have entered wrong selection 3 times.\n Exiting...");
                        System.exit(0);
                    }
                    System.out.println("Wrong input! Enter correct selection.");
                    running++;
                    break;
            }
        }
    }

    }

