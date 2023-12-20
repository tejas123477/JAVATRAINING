package com.hexaware.tbs.hra;

public class Venue {
    String venue_name, address;
    Venue(){}
    Venue(String venue_name, String address){
        this.venue_name = venue_name;
        this.address = address;
    }
    String getVenue_name()
    {
        return this.venue_name;
    }
    String getAddress()
    {
        return this.address;
    }
    void setVenue_name(String venue_name){
        this.venue_name = venue_name;
    }
    void setAddress(String address){
        this.address = address;
    }
    void display_venue_details(){
        System.out.println("Venue Name: " + getVenue_name());
        System.out.println("Venue Address: " + getAddress());
    }
}
