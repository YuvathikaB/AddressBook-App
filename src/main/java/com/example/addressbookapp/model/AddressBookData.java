package com.example.addressbookapp.model;

import com.example.addressbookapp.dto.*;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Objects;

@Entity 
public class AddressBookData {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    
    public AddressBookData() {
    }

    public AddressBookData(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.phoneNumber = addressBookDTO.getPhoneNumber();
        this.email = addressBookDTO.getEmail();
    }
    
    public Long getId() {
        return id;
    }

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
    
    public void setId(Long id) { 
        this.id = id;
    }

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
    
    @Override
    public String toString() {
        return "AddressBookData{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBookData that = (AddressBookData) o;
        return Objects.equals(id, that.id) && // Include ID in equals/hashCode for entities
               Objects.equals(firstName, that.firstName) &&
               Objects.equals(lastName, that.lastName) &&
               Objects.equals(phoneNumber, that.phoneNumber) &&
               Objects.equals(email, that.email);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, email); // Include ID in hash
    }
    
    
}