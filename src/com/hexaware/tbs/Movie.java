package com.hexaware.tbs;

public class Movie extends Event{
    String genre, actor_name, actress_name;
    Movie(){}
    Movie(String genre, String actor_name, String actress_name)
    {
        this.genre = genre;
        this.actor_name = actor_name;
        this.actress_name = actress_name;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getActor_name() {
        return this.actor_name;
    }

    public String getActress_name() {
        return this.actress_name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public void setActress_name(String actress_name) {
        this.actress_name = actress_name;
    }
    @Override
    public void display_event_details(){
        System.out.println("Genre: "+ this.genre);
        System.out.println("Actor name: " + this.actor_name);
        System.out.println("Actress name: " + this.actress_name);
    }

    public static void main(String[] args)
    {
        Movie m1=new Movie("horror","tom cruise","scarlett");
        m1.display_event_details();
    }


}
