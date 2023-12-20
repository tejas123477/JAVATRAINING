package com.hexaware.repo;

import com.hexaware.entity.Customer;
import com.hexaware.entity.Event;
import com.hexaware.entity.EventType;
import com.hexaware.entity.Venue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public interface IBookingSystemRepository {
    public boolean createEvent(String eventName, LocalDate date, LocalTime time, Integer totalSeats, Double ticket_price,
                             Venue venue, EventType eventType);
    ArrayList<String> getEventDetails();
    Integer getAvailableNoOfTickets();
    Double calculateBookingCost(String eventName, Integer numTickets);
    void bookTickets(String eventName, int numTickets, ArrayList<Customer> customers);
    boolean cancelBooking(int bookingID);
    void getBookingDetails(int bookingID);
}
