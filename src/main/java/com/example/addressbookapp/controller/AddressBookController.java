package com.example.addressbookapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@Autowired
    private IAddressBookService addressBookService;
	
	@GetMapping("/getall")
    public ResponseEntity<List<AddressBookData>> getAllAddressBookData() {
        List<AddressBookData> addressBookList = addressBookService.getAllAddressBookData();
        return new ResponseEntity<>(addressBookList, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookData> getAddressBookData(@PathVariable Long id) {
        AddressBookData addressBookData = addressBookService.getAddressBookDataById(id);
        return new ResponseEntity<>(addressBookData, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AddressBookData> createAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookService.createAddressBookData(addressBookDTO);
        return new ResponseEntity<>(addressBookData, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookData> updateAddressBookData(@PathVariable Long id, @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = addressBookService.updateAddressBookData(id, addressBookDTO);
        return new ResponseEntity<>(addressBookData, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressBookData(@PathVariable Long id) {
        addressBookService.deleteAddressBookData(id);
        return new ResponseEntity<>("Deleted successfully!", HttpStatus.NO_CONTENT);
    }

}
