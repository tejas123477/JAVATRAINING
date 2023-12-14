package com.hexaware.tbs;

public class Customer {
    public Customer(String name, String email, Number phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    String name;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    String email;

    Number phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Number getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Number phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void display_customer_details()
    {
        System.out.println(getName()+" "+getEmail()+" "+getPhoneNumber());
    }

    public static void main(String[] args)
    {
        Customer c1=new Customer("tejas","raitejas16@gmail.com",76586969);
        c1.display_customer_details();
    }
}
