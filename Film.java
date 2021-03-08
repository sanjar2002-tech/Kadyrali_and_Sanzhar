package com.company.model.entities;

public class Film {

    //private variables
    private int id;
    private String name;
    private String genre;
    private boolean subscription;
    private float rating;


    // contractors, with id and without
    public Film(int id, String name, String genre, boolean subscription, float rating) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.subscription = subscription;
        this.rating = rating;
    }

    public Film(String name, String genre, boolean subscription, float rating) {
        this.name = name;
        this.genre = genre;
        this.subscription = subscription;
        this.rating = rating;
    }


    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }




    // to show information about film
    public String toString(){
        String s = "ID: " + id + "| " + name + "   Genre: " + genre + '\n';
        if(subscription){
            s += "This film requires subscription\n";
        } else {
            s += "This film don't requires subscription\n";
        }
        s += "Rating: " + rating;
        s += "\n ----------------------------- ";
        return s;
    }
}
