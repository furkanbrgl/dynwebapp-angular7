package com.furkanbrgl.dynwebappangular7.dto;

public class UserDto {
    private Long id;
    private String nameSurname;

    public UserDto() {
    }

    public UserDto(Long id, String nameSurname) {
        this.id = id;
        this.nameSurname = nameSurname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }
}