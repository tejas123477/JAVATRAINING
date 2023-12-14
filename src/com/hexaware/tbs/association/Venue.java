package com.hexaware.tbs.association;


import java.time.LocalDate;
import java.time.LocalTime;

public class Venue {
        private String venue_name;
        private String address;

        // Default constructor
        public Venue() {
        }

        // Overloaded constructor
        public Venue(String venue_name, String address) {
            this.venue_name = venue_name;
            this.address = address;
        }

        // Getter and setter methods for venue_name
        public String getVenue_name() {
            return venue_name;
        }

        public void setVenue_name(String venue_name) {
            this.venue_name = venue_name;
        }

        // Getter and setter methods for address
        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        // Method to display venue details
        public void display_venue_details() {
            System.out.println("Venue Name: " + venue_name);
            System.out.println("Address: " + address);
        }

        public static void main(String[] args) {
            // Example usage
            Venue venue = new Venue("Example Venue", "123 Main Street, Cityville");
            venue.display_venue_details();
            Customer customer=new Customer("tejas","raitejas16@gmail.com","8009339717");
            customer.display_customer_details();
            Movie movie=new Movie("Movies", LocalDate.of(2023,12,2), LocalTime.of(2,30),"harmony",100,60,Event.EventType.Movie,"horror","tejas","isha");
            movie.display_event_details();
        }
    }
