package com.hexaware.tbs.hra;

import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {
    int bookingId;
    ArrayList<Customer> customerArray = new ArrayList<>();
    Event event;
    ArrayList<Integer> numTickets = new ArrayList<>();
    double totalCost;
    LocalDate bookingDate;
    public Booking(int bookingId, ArrayList<Customer> customerArray,Event event, ArrayList<Integer> numTickets){
        this.bookingId = bookingId;
        this.customerArray = customerArray;
        this.event = event;
        this.numTickets = numTickets;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public ArrayList<Customer> getCustomerArray() {
        return customerArray;
    }

    public void setCustomerArray(ArrayList<Customer> customerArray) {
        this.customerArray = customerArray;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public ArrayList<Integer> getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(ArrayList<Integer> numTickets) {
        this.numTickets = numTickets;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public boolean displayBookingDetails(){
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Total customers: " + customerArray.size());
        System.out.println("Total cost: " + totalCost);
        System.out.println("Booking Date: " + bookingDate);
        return true;
    }



}
