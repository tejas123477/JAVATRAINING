package com.hexaware.tbs.interfaces;

public class Venue {

    public Venue(String venue_name, String address) {
        this.venue_name = venue_name;
        this.address = address;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public String setVenue_name(String venue_name) {
        this.venue_name = venue_name;
        return venue_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venue_name='" + venue_name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    String venue_name;
    String address;
}
