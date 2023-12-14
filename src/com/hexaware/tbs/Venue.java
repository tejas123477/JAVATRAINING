package com.hexaware.tbs;

public class Venue {

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
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
                "venueName='" + venueName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    String venueName;
    String address;

    public Venue(String venueName, String address) {
        this.venueName = venueName;
        this.address = address;
    }

    void display_venue_details()
    {
        System.out.println(getVenueName());
        System.out.println(getAddress());
    }

    public static void main(String[] args)
    {
        Venue v1=new Venue("bose","noida park");
        v1.display_venue_details();
    }


}
