package com.hexaware.tbs;
import java.util.Scanner;

import com.hexaware.tbs.Event;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TicketBookingSystem extends Event {

    public Event event;
    public Event create_event(String eventName, LocalDate eventDate, LocalTime eventTime, String venueName, int totalSeats, int availableSeats, float ticketPrice) {
        Event obj = new Event(eventName, eventDate, eventTime, venueName, totalSeats, availableSeats, ticketPrice);
        return obj;
    }

    public void display_event_details(Event event) {
        event.display_event_details();
    }

    public static double book_tickets(Event event, int num_tickets) {
        if (event.getAvailableSeats() >= num_tickets) {
            event.setAvailableSeats(event.getAvailableSeats() - num_tickets);
            return event.getTicketPrice() * num_tickets;
        }
        System.out.println("Event is sold out!");
        return -1;
    }

    public boolean cancel_tickets(Event event, int num_tickets) {
        event.setAvailableSeats(event.getAvailableSeats() + num_tickets);
        return true;
    }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int opt = 0,i = 0, ev,no;
            double ticket_price;
            String event_name, date, time, venue;
            LocalDate eventDate;
            Event.eventType type;
            int total_seats;
            ArrayList<Event> eventList = new ArrayList<>();

            eventList.add(new Event("Action Movie Premiere", LocalDate.of(2023, 12, 28), LocalTime.of(19, 0),
                    "Cinema Hall 1", 300, 300, 12));
            eventList.add(new Event("Pop Music Festival", LocalDate.of(2023, 11, 10), LocalTime.of(21, 0),
                    "Music Stadium", 1500, 1500, 40));
            eventList.add(new Event("Soccer Championship", LocalDate.of(2023, 12, 1), LocalTime.of(17, 30),
                    "Soccer Arena", 8000, 8000, 60));

            boolean a = true;
            while(a){
                System.out.println("1. Book Event Ticket.");
                System.out.println("2. Input Events.");
                System.out.print("Input Slection :");
                opt = sc.nextInt();

                switch(opt){
                    case (1):
                        System.out.println("------------------------------------------------------");
                        for(i = 0; i<eventList.size(); i++){
                            System.out.println("Event: "+(i+1));
                            eventList.get(i).display_event_details();
                            System.out.println("------------------------------------------------------");
                        }
                        System.out.print("Input event number from list for booking: ");
                        ev = sc.nextInt();
                        System.out.print("Enter no. of tickets: ");
                        no = sc.nextInt();
                        ticket_price = book_tickets(eventList.get(ev-1), no);
                        System.out.println("Ticket price: "+ ticket_price);
                        System.out.println("------------------------------------------------------");
                        break;
                    case (2):
                        sc.nextLine();
                        System.out.print("Enter event name: ");
                        event_name = sc.nextLine();
                        System.out.print("Enter event date (yyyy/mm/dd): ");
                        date = sc.nextLine();
                        System.out.print("Enter event time (HH:MM): ");
                        time = sc.nextLine();
                        System.out.print("Enter venue: ");
                        venue = sc.nextLine();
                        System.out.print("Enter total seats ");
                        total_seats = sc.nextInt();
                        System.out.print("Ticket price: ");
                        ticket_price = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Event type (Movie/ Sports/ Concert): ");
                        type = Event.eventType.valueOf(sc.nextLine());
                        //eventList.add(new Event(event_name, LocalDate.of(2023,11,23), LocalTime.parse(time), venue, total_seats, total_seats,ticket_price,type));
                        //ventList.add(new Event(event, LocalDate.parse(date), LocalTime.parse(time), venue, total_seats, total_seats,ticket_price,type));
                        //eventName, eventDate, eventTime, venueName, totalSeats, availableSeats, ticketPrice
                        System.out.println("Event added successfully.");
                        break;

                    default:
                        a = false;
                        break;
                }
            }
        }
    }

