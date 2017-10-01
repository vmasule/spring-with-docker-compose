package com.bd.example.serviceone.model;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
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
