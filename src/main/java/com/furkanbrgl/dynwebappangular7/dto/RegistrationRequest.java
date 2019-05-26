package com.furkanbrgl.dynwebappangular7.dto;

public class RegistrationRequest {

    String nameSurname;
    String password;
    String username;
    String email;

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegistrationRequest() {
    }

    public RegistrationRequest(String nameSurname, String password, String username, String email) {
        this.nameSurname = nameSurname;
        this.password = password;
        this.username = username;
        this.email = email;
    }
}
