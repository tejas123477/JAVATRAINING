package com.hexaware.repo;

import com.hexaware.entity.*;
import com.hexaware.util.DBConnectionUtil;
import com.hexaware.util.DBPropertyUtil;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class BookingSystemRepositoryImpl implements IBookingSystemRepository{
    String str = DBPropertyUtil.getConnectionString("resources\\tbs.properties");
    Connection con = DBConnectionUtil.getDBConnection(str);
    ArrayList<Event> events = new ArrayList<>();

    @Override
    public boolean createEvent(String eventName, LocalDate date, LocalTime time, Integer totalSeats, Double ticket_price, Venue venue, EventType eventType) {
        String query = "insert into events values (?,?,?,?,?,?,?,?,?)";
        String query1 = "select max(event_id) as max_event_id, max(booking_id) as max_booking_id from events";
        PreparedStatement ps = null;
        Statement s = null;
        int max_bookingID = 0;
        int max_eventID = 0;
        try{
            ResultSet rs1 = null;
            s = con.createStatement();
            rs1 = s.executeQuery(query1);
            if(rs1.next()){
                max_eventID = rs1.getInt("max_event_id");
                max_bookingID = rs1.getInt("max_booking_id");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            ps = con.prepareStatement(query);
            ps.setInt(1,max_eventID + 1);
            ps.setString(2,eventName);
            ps.setDate(3, Date.valueOf(date));
            ps.setTime(4, Time.valueOf(time));
            ps.setInt(5,totalSeats);
            ps.setInt(6,totalSeats);
            ps.setDouble(7,ticket_price);
            ps.setInt(8,venue.getVenueID());
            ps.setString(9,eventName.toString());
            ps.setInt(10,max_bookingID + 1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        Event newEvent = null;
        if(eventType.toString().equals("Movie")){
            newEvent = new Movie(eventName, date, time, venue, totalSeats, ticket_price, EventType.Movie );
        } else if (eventType.toString().equals("Sports")) {
            newEvent = new Sports(eventName, date, time, venue, totalSeats, ticket_price, EventType.Sports );
        } else if(eventType.toString().equals("Concert")) {
            newEvent = new Concert(eventName,date, time, venue, totalSeats, ticket_price, EventType.Concert);
        }
        events.add(newEvent);
        return true;
    }

    @Override
    public ArrayList<String> getEventDetails() {
        ArrayList<String> eventDetails = new ArrayList<>();
        String query = "select event_id, event_name, event_date, event_time from events";
        ResultSet rs = null;
        Statement s = null;
        System.out.println("All Events List");
        try{
            s = con.createStatement();
            rs = s.executeQuery(query);

            while(rs.next()){
                eventDetails.add(rs.getString("event_name") + " " + rs.getDate("event_date").toString() + " " + rs.getTime("event_time").toString());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return eventDetails;
    }

    @Override
    public Integer getAvailableNoOfTickets() {
        String query = "select sum(available_seats) as sum from events";
        int sum = 0;
        Statement s = null;
        ResultSet rs = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery(query);
            if(rs.next()){
                sum = rs.getInt("sum");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sum;
    }

    @Override
    public Double calculateBookingCost(String eventName, Integer numTickets) {
        String query = "Select ticketPrice from Events where eventName = ?";
        double price = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(query);
            ps.setString(1,eventName);

            rs = ps.executeQuery();
            price = rs.getDouble(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return price * numTickets;
    }

    @Override
    public void bookTickets(String eventName, int numTickets, ArrayList<Customer> customers) {
        String query1 = "insert into customer value (?,?,?,?,?)";
        String query2 = "select customer_id from customer where customer_name = ?";
        String query3 = "select max(customer_id) from customer";
        String query4 = "insert into booking value (?,?,?,?,?,?)";
        String query5 = "select event_id from events where event_name = ?";
        String query6 = "select max(booking_id) from booking";
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        int customer_id = 0;
        int max_customer_id = 0;
        int event_id = 0;
        int max_booking_id = 0;
        try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.prepareStatement(query6);
            rs = ps.executeQuery();
            max_booking_id = rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.prepareStatement(query5);
            rs = ps.executeQuery();
            event_id = rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            ResultSet rs = null;
            Statement s = con.createStatement();
            rs = s.executeQuery(query3);
            max_customer_id = rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try{
            ResultSet rs1 = null;
            ps2 = con.prepareStatement(query2);
            ps2.setString(1,customers.get(0).getCustomerName());
            customer_id = rs1.getInt(1);

            if(customer_id == 0){
                try{
                    ResultSet rs2 = null;
                    ps1 = con.prepareStatement(query1);
                    ps1.setInt(1, max_customer_id + 1);
                    ps2.setString(2,customers.get(0).getCustomerName());
                    ps2.setString(3,customers.get(0).getEmail());
                    ps2.setString(4,customers.get(0).getPhoneNo());
                    ps2.setInt(5,max_booking_id+1);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            try{
                ResultSet rs = null;
                PreparedStatement ps = null;
                ps = con.prepareStatement(query4);
                ps.setInt(1, max_booking_id + 1);
                ps.setInt(2,customer_id);
                ps.setInt(3,event_id);
                ps.setInt(4,numTickets);
//                ps.setDouble(5,numTickets*e.get);
                ps.setDate(6,Date.valueOf(LocalDate.now()));


            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean cancelBooking(int bookingID) {
        String query = "Delete from booking where booking_id = ?";
        PreparedStatement ps = null;
        try {
            ResultSet rs = null;
            ps = con.prepareStatement(query);
            ps.setInt(1,bookingID);
            rs = ps.executeQuery();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return true;
    }

    @Override
    public void getBookingDetails(int bookingID) {
        String query = "Select c.customer_name, event_name, booking_date, num_tickets, total_cost from booking b " +
                "left join customer c on c.customer_id = b.customer_id " +
                "left join events e on b.event_id = e.event_id";
        Statement s = null;
        try {
            ResultSet rs = null;
            s = con.createStatement();
            rs = s.executeQuery(query);
            if(rs.next()){
                System.out.println("Customer : " + rs.getString("c.customer_name"));
                System.out.println("Event : " + rs.getString("event_name"));
                System.out.println("Booking Date : " + rs.getDate(3).toString());
                System.out.println("Number of Tickets Booked : " + rs.getInt(4));
                System.out.println("Total Cost : " + rs.getDouble(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        BookingSystemRepositoryImpl aa = new BookingSystemRepositoryImpl();
        a = aa.getEventDetails();
//        System.out.println(aa.getAvailableNoOfTickets());
        aa.getBookingDetails(201);
    }
}
