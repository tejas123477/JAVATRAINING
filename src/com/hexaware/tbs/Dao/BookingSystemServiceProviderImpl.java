package com.hexaware.dao;

import com.hexaware.entity.Booking;
import com.hexaware.entity.Customer;
import com.hexaware.entity.Event;

import java.util.ArrayList;
import java.util.Objects;

public class BookingSystemServiceProviderImpl extends EventServiceProviderImpl implements IBookingSystemServiceProvider{
    public ArrayList<Booking> bookings = new ArrayList<>();
    Booking b = null;
    ArrayList<Event> events = super.events;
    @Override
    public double calculateBookingSystem(Event e, int numTickets) {
        return e.getTicketPrice() * numTickets;
    }

    @Override
    public void bookTickets(String eventName, int numTickets, ArrayList<Customer> customers) {
        Event event = null;
        for(Event e : events){
            if(e.getEventName().equals(eventName)){
                event = e;
                break;
            }
        }
        if(event.bookTickets(numTickets)){
            b = new Booking(bookings.size()+1, customers, event, numTickets); //auto increment required
        }
        bookings.add(b);
        event.setAvailableSeats(event.getAvailableSeats() - numTickets);
    }

    @Override
    public void cancelBooking(int bookingID) {
        for(int i=0;i<bookings.size();i++){
            if(bookings.get(i).getBookingID() == bookingID){
                Booking rb = bookings.get(i);
//                rb.getEvent().setAvailable_seats(rb.getEvent().getAvailable_seats() + rb.getNumTickets());
                rb.getEvent().cancelBooking(rb.getNumTickets());
                bookings.remove(rb);
            }
        }
    }

    @Override
    public void getBookingDetails(int bookingID) {
//        displayBookingDetails
        System.out.println("Booking Id : " + bookingID);
        System.out.println("Event Name : " + b.getEvent().getEventName());
        System.out.println("Total Tickets : " + b.getNumTickets());
        ArrayList<Customer> cl = b.getCustomers();
        for (Customer customer : cl) {
            customer.customerDetails();
        }
    }
}
