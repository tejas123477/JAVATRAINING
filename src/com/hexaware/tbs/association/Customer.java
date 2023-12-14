package com.hexaware.tbs.association;

public class Customer {
    private String customer_name;
    private String email;
    private String phone_number;

    // Default constructor
    public Customer() {
    }

    // Overloaded constructor with parameters
    public Customer(String customer_name, String email, String phone_number) {
        this.customer_name = customer_name;
        this.email = email;
        this.phone_number = phone_number;
    }

    // Getter and setter methods for customer_name
    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    // Getter and setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and setter methods for phone_number
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    // Display customer details method
    public void display_customer_details() {
        System.out.println("Customer Name: " + customer_name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phone_number);
    }
}
