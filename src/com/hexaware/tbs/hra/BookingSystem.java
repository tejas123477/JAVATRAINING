package com.hexaware.tbs.hra;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookingSystem {
    ArrayList<Event> eventList = new ArrayList<>();
    ArrayList<Booking> bookingArray = new ArrayList<>();
    public Event createEvent(String event_name, String date, String time, int total_seats, double ticket_price, Event.event_type e_type, Venue venue){
        Event obj = null;
        String genre, actor_name, actress_name, artist, artist_type, sport_name;
        String[] team_names = new String[2];
        Scanner sc = new Scanner(System.in);

        switch(e_type){
            case Event.event_type.Movie :
                System.out.print("Enter genre: ");
                genre = sc.nextLine();
                System.out.print("Enter actor name: ");
                actor_name = sc.nextLine();
                System.out.print("Enter actress name: ");
                actress_name = sc.nextLine();
                obj = new Movie(event_name, LocalDate.parse(date), LocalTime.parse(time), venue, total_seats, total_seats,ticket_price, e_type, genre, actor_name, actress_name);
                break;
            case Event.event_type.Concert :
                System.out.println("Enter artist: ");
                artist = sc.nextLine();
                System.out.println("Enter artist type: ");
                artist_type = sc.nextLine();
                obj = new Concert(event_name, LocalDate.parse(date), LocalTime.parse(time), venue, total_seats, total_seats,ticket_price, e_type, artist, artist_type);
                break;

            case Event.event_type.Sports :
                System.out.println("Enter sport name: ");
                sport_name = sc.nextLine();
                System.out.println("Enter team 1 name: ");
                team_names[0] = sc.nextLine();
                System.out.println("Enter team 2 name: ");
                team_names[1] = sc.nextLine();
                obj = new Sports(event_name, LocalDate.parse(date), LocalTime.parse(time), venue, total_seats, total_seats, ticket_price, e_type, sport_name, team_names);
        }
        return obj;
    }
    double calculateBookingCost(Event event, int num_tickets){
        return num_tickets * event.getTicket_price();
    }
    public Booking bookTickets(int bookingId,Event event, ArrayList<Integer> numTickets, ArrayList<Customer> customers){
        Booking bookingObj = new Booking(bookingId, customers, event, numTickets);
        return bookingObj;
    }
    public boolean cancelBooking(BookingSystem bs,int bookingId){
        Booking temp = null;
        int sumTickets=0;
        for(int i=0; i<bs.bookingArray.size();i++){
            if (bs.bookingArray.get(i).bookingId == bookingId){
                temp = bs.bookingArray.get(i);
                for (int no: temp.numTickets) {
                    sumTickets+=no;
                }
                temp.event.setAvailable_seats(temp.event.getTotal_seats()+sumTickets);
                bs.bookingArray.remove(i);
                return true;
            }
        }
        return false;
    }
    public List[] inputCustomerDetails(){
        ArrayList<Customer> customerList = new ArrayList<>();
        ArrayList<Integer> numTickets = new ArrayList<>();
        String name, email, phone;
        int tickets, tempAdd;
        Scanner sc = new Scanner(System.in);
        int ip = 1;
        while(ip != 0){
            System.out.println("Customer " + ip + " details:");
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Email: ");
            email = sc.nextLine();
            System.out.print("Phone: ");
            phone = sc.nextLine();
            System.out.print("Number of tickets to be booked: ");
            tickets = sc.nextInt();
            customerList.add(new Customer(name, email, phone));
            numTickets.add(tickets);
            System.out.println("Customer added.");
            System.out.println("1. Add more customers");
            System.out.println("2. Generate bill");
            tempAdd = sc.nextInt();
            sc.nextLine();
            if (tempAdd == 1){
                ip++;
            } else {
                ip = 0;
                break;
            }
        }
        return new List[] { customerList, numTickets };
    }
    public int getAvailableNoOfTickets(Event event){
        return event.get_available_no_of_tickets();
    }

    public void getEventDetails(Event event) {
        event.display_event_details();
    }

    public static void main(String[] args){
        BookingSystem bs = new BookingSystem();
        Scanner sc = new Scanner(System.in);

        String event_name, venue_name, venue_address, date, time;
        int total_seats, select, i, eventNo, bookingCount,sum = 0, cancelCount, availableCount, bookingId;
        double ticket_price, bookingCost;
        Event.event_type e_type;
        int running = 0;
        while( true ) {
            System.out.println("1. Create Event.");
            System.out.println("2. Book Tickets.");
            System.out.println("3. Cancel Tickets.");
            System.out.println("4. Get Available Seats.");
            System.out.println("5. Get Event Details.");
            System.out.println("6 Exit.");
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
                    System.out.print("Enter venue name: ");
                    venue_name = sc.nextLine();
                    System.out.print("Enter venue address: ");
                    venue_address = sc.nextLine();
                    System.out.print("Enter total seats: ");
                    total_seats = sc.nextInt();
                    System.out.print("Ticket price: ");
                    ticket_price = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Event type (Movie/ Sports/ Concert): ");
                    e_type = Event.event_type.valueOf(sc.nextLine());
                    bs.eventList.add(bs.createEvent(event_name, date, time, total_seats, ticket_price, e_type, new Venue(venue_name,venue_address)));
                    System.out.println("Event added successfully.");
                    break;

                case 2:
                    System.out.println("------------------------------------------------------");
                    for (i = 0; i < bs.eventList.size(); i++) {
                        System.out.println("Event: " + (i + 1));
                        bs.getEventDetails(bs.eventList.get(i));
                        System.out.println("------------------------------------------------------");
                    }
                    if (bs.eventList.size() > 0) {
                        List[] custTicketObjList = null;
                        System.out.print("Input event number from list for booking: ");
                        eventNo = sc.nextInt();
                        System.out.println("ENTER CUSTOMER DETAILS ");
                        custTicketObjList = bs.inputCustomerDetails();
                        ArrayList<Customer> firstList = (ArrayList<Customer>) custTicketObjList[0];
                        ArrayList<Integer> secondList = (ArrayList<Integer>) custTicketObjList[1];
                        if(bs.bookingArray.size()>0)
                            bookingId = bs.bookingArray.get(bs.bookingArray.size()-1).bookingId + 1;
                        else
                            bookingId = 1;
                        bs.bookingArray.add(bs.bookTickets(bookingId,bs.eventList.get(eventNo - 1), (ArrayList<Integer>) custTicketObjList[1], (ArrayList<Customer>) custTicketObjList[0]));
                        System.out.println("Booking Done");
                        for (i = 0; i< secondList.size(); i++){
                            sum += secondList.get(i);
                        }
                        bookingCost = bs.calculateBookingCost(bs.eventList.get(eventNo - 1), sum);
                        System.out.println("Total booking cost: " + bookingCost);
                        System.out.println("------------------------------------------------------");
                        break;
                    }
                    else{
                        System.out.println("No events available! Please add event first.");
                        break;
                    }
                case 3:
                    System.out.println("------------------------------------------------------");
                    for (i = 0; i < bs.bookingArray.size(); i++) {
                        System.out.println("Booking: " + (i + 1));
                        bs.bookingArray.get(i).displayBookingDetails();
                        System.out.println("------------------------------------------------------");
                    }
                    if (bs.bookingArray.size() > 0) {
                        System.out.print("Input bookingId from list for cancelling: ");
                        bookingId = sc.nextInt();
                        bs.cancelBooking(bs, bookingId);
                        System.out.println("------------------------------------------------------");
                        break;
                    }
                    else{
                        System.out.println("No bookings available! Please do booking first.");
                        break;
                    }
                case 4:
                    System.out.println("------------------------------------------------------");
                    for (i = 0; i < bs.eventList.size(); i++) {
                        System.out.println("Event: " + (i + 1));
                        bs.getEventDetails(bs.eventList.get(i));
                        System.out.println("------------------------------------------------------");
                    }
                    if(bs.eventList.size() > 0) {
                        System.out.print("Input event number from list to check availability: ");
                        eventNo = sc.nextInt();
                        availableCount = bs.getAvailableNoOfTickets(bs.eventList.get(eventNo - 1));
                        System.out.println("Available seats: " + availableCount);
                        System.out.println("------------------------------------------------------");
                        break;
                    }
                    else{
                        System.out.println("No events available! Please add event first.");
                        break;
                    }
                case 5:
                    System.out.println("------------------------------------------------------");
                    for (i = 0; i < bs.eventList.size(); i++) {
                        System.out.println("Event: " + (i + 1));
                        bs.getEventDetails(bs.eventList.get(i));
                        System.out.println("------------------------------------------------------");
                    }
                    if(bs.eventList.size() == 0) {
                        System.out.println("No events available! Please add event first.");
                        break;
                    }
                    break;
                case 6:
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
