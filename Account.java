package com.company.model.entities;

public class Account {

    //private variables
    private String login;
    private String password;

    private boolean subscription;


    //constractor
    public Account(String login, String password, boolean subscription) {
        this.login = login;
        this.password = password;
        this.subscription = subscription;
    }


    //getters and setters
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }


}
