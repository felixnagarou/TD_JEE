package com.example.td_jee.models;

public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String mail;

    public UserDTO(){
        this.id = 0L;
        this.username = "";
        this.password = "";
        this.mail = "";
    }

    public UserDTO(Long id, String username, String password, String mail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
