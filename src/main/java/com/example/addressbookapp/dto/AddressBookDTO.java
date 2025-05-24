package com.example.addressbookapp.dto; // Ensure this matches your package structure

import java.util.Objects; // Needed for Objects.equals and Objects.hash
import jakarta.validation.constraints.*;

public class AddressBookDTO {
	@NotBlank(message = "First Name cannot be blank") 
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First Name Invalid: Should start with a capital letter and have at least 3 characters")
    private String firstName;

    @NotBlank(message = "Last Name cannot be blank")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Last Name Invalid: Should start with a capital letter and have at least 3 characters")
    private String lastName;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone Number Invalid: Must be 10 digits")
    private String phoneNumber;

    @Email(message = "Email Invalid: Must be a valid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;
   

    public AddressBookDTO() {
    }

    public AddressBookDTO(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
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
        return "AddressBookDTO{" +
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", email='" + email + '\'' +
               '}';
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, email);
    }
}