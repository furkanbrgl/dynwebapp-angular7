package com.furkanbrgl.dynwebappangular7.dto;

public class TokenResponse {
    private String username;
    private String token;

    public TokenResponse(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public TokenResponse() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}