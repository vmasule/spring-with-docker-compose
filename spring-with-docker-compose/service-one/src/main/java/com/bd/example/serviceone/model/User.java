package com.bd.example.serviceone.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class User implements Serializable {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;
    private String password;

    @NotNull
    @Min(value = 1)
    private Integer contactNumber;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, Integer contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
