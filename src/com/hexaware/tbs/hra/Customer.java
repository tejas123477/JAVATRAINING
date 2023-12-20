package com.hexaware.tbs.hra;
public class Customer {
    String customer_name, email, phone_number;
    Customer(){}
    Customer(String customer_name, String email, String phone_number)
    {
        this.customer_name = customer_name;
        this.email = email;
        this.phone_number = phone_number;
    }
    String getCustomer_name()
    {
        return this.customer_name;
    }
    String getEmail()
    {
        return this.email;
    }
    String getPhone_number()
    {
        return this.phone_number;
    }

    void setCustomer_name(String customer_name)
    {
        this.customer_name = customer_name;
    }
    void setEmail(String email)
    {
        this.email = email;
    }

    void setPhone_number(String phone_number)
    {
        this.phone_number = phone_number;
    }

    void display_customer_details()
    {
        System.out.println("Customer name: "+getCustomer_name());
        System.out.println("Email: "+ getEmail());
        System.out.println("Phone number: "+ getPhone_number());
    }
}
