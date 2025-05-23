package com.example.addressbookapp.dto; // Ensure this matches your package structure

import java.util.Objects; // Needed for Objects.equals and Objects.hash

public class AddressBookDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    // --- Constructor (No-argument constructor - important for Spring/Jackson) ---
    public AddressBookDTO() {
    }

    // --- Constructor with all fields (optional, but often useful) ---
    public AddressBookDTO(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // --- Getters ---
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // --- Setters ---
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // --- toString() ---
    @Override
    public String toString() {
        return "AddressBookDTO{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", email='" + email + '\'' +
               '}';
    }

    // --- equals() ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBookDTO that = (AddressBookDTO) o;
        return Objects.equals(firstName, that.firstName) &&
               Objects.equals(lastName, that.lastName) &&
               Objects.equals(phoneNumber, that.phoneNumber) &&
               Objects.equals(email, that.email);
    }

    // --- hashCode() ---
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, email);
    }
}