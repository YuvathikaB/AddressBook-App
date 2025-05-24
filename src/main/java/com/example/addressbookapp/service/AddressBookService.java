package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.exception.AddressBookException;
import com.example.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import com.example.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
	@Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        log.info("Service: Creating address book data for: {}", addressBookDTO);
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        return addressBookRepository.save(addressBookData);
    }

    @Override
    public List<AddressBookData> getAllAddressBookData() {
        log.info("Service: Retrieving all address book data.");
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBookData getAddressBookDataById(Long id) {
        log.info("Service: Retrieving address book data by ID: {}", id);
        return addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookException("Address Book ID not found: " + id));
    }

    @Override
    public AddressBookData updateAddressBookData(Long id, AddressBookDTO addressBookDTO) {
        log.info("Service: Updating address book data for ID: {}", id);
        AddressBookData existingAddressBookData = addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookException("Address Book ID not found for update: " + id));

        existingAddressBookData.setFirstName(addressBookDTO.getFirstName());
        existingAddressBookData.setLastName(addressBookDTO.getLastName());
        existingAddressBookData.setPhoneNumber(addressBookDTO.getPhoneNumber());
        existingAddressBookData.setEmail(addressBookDTO.getEmail());

        return addressBookRepository.save(existingAddressBookData);
    }

    @Override
    public void deleteAddressBookData(Long id) {
        log.info("Service: Deleting address book data for ID: {}", id);
        AddressBookData addressBookData = addressBookRepository.findById(id)
                .orElseThrow(() -> new AddressBookException("Address Book ID not found for delete: " + id));
        addressBookRepository.delete(addressBookData);
    }
}