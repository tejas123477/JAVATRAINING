package com.hexaware.tbs.Exception;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(String eventName) {
        super("Event not found: " + eventName);
    }
}
