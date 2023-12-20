package com.hexaware.tbs.Test;

import com.hexaware.dao.BookingSystemServiceProviderImpl;
import com.hexaware.tbs.Booking;
import com.hexaware.tbs.Event;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void createProduct() {
        com.hexaware.dao.BookingSystemServiceProviderImpl orderProcessorRepository=new BookingSystemServiceProviderImpl();
        Booking b=new Booking();

        boolean ans=orderProcessorRepository.cancelBooking(3);
        assertEquals(true,ans);


    }

    void booktickets() {
        com.hexaware.dao.BookingSystemServiceProviderImpl orderProcessorRepository=new BookingSystemServiceProviderImpl();
        Booking b=new Booking();
        Event e=new Event();
        boolean ans=orderProcessorRepository.calculateBookingSystem(e,1);
        assertEquals(true,ans);


    }
}