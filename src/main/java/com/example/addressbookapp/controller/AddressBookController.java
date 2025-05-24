package com.example.addressbookapp.controller;

import org.springframework.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {
	
	@Autowired
    private IAddressBookService addressBookService;
	
	@GetMapping(value = {"", "/", "/get"})
    public ResponseEntity<List<AddressBookData>> getAllAddressBookData() {
        log.info("Controller: Handling GET request for all address book data.");
        List<AddressBookData> addressBookList = addressBookService.getAllAddressBookData();
        return new ResponseEntity<>(addressBookList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookData> getAddressBookDataById(@PathVariable("id") Long id) {
        log.info("Controller: Handling GET request for address book data with ID: {}", id);
        AddressBookData addressBookData = addressBookService.getAddressBookDataById(id);
        if (addressBookData != null) {
            return new ResponseEntity<>(addressBookData, HttpStatus.OK);
        }
        log.warn("Controller: Address book data not found for ID: {}", id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if not found
    }

    @PostMapping("/create")
    public ResponseEntity<AddressBookData> createAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
        log.info("Controller: Handling POST request to create new address book data: {}", addressBookDTO);
        AddressBookData addressBookData = addressBookService.createAddressBookData(addressBookDTO);
        return new ResponseEntity<>(addressBookData, HttpStatus.CREATED); // Return 201 Created
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookData> updateAddressBookData(@PathVariable("id") Long id, @RequestBody AddressBookDTO addressBookDTO) {
        log.info("Controller: Handling PUT request to update address book data for ID: {}", id);
        AddressBookData addressBookData = addressBookService.updateAddressBookData(id, addressBookDTO);
        if (addressBookData != null) {
            return new ResponseEntity<>(addressBookData, HttpStatus.OK);
        }
        log.warn("Controller: Attempted to update non-existent address book data with ID: {}", id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if not found for update
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAddressBookData(@PathVariable("id") Long id) {
        log.info("Controller: Handling DELETE request for address book data with ID: {}", id);
        addressBookService.deleteAddressBookData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Return 204 No Content
    }
}