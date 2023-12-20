package com.hexaware.dao;

import com.hexaware.entity.Customer;
import com.hexaware.entity.Event;

import java.util.*;

public interface IBookingSystemServiceProvider {
    double calculateBookingSystem(Event e, int numTickets);
    void bookTickets(String eventName, int numTickets, ArrayList<Customer> customers);
    void cancelBooking(int bookingID);
    void getBookingDetails(int bookingID);
}
