package com.example.td_jee.models;

import java.util.List;

public class User {

    public static Long count=0L;
    private final Long id;
    private String username;
    private String password;
    private String mail;

    private List<Book> userFavorites;

    public User(){
        this.id = ++count;
    }

    public User(String username, String password, String mail) {
        this.id = ++count;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Book> getUserFavorites(){return userFavorites;}
}
