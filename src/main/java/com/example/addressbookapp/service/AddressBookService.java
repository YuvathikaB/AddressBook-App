package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import lombok.extern.slf4j.Slf4j;
import com.example.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
	private List<AddressBookData> addressBookList = new ArrayList<>();
    private Long counter = 0L;
    
    @Override
    public List<AddressBookData> getAllAddressBookData() {
        log.info("Service: Retrieving all address book data.");
        return addressBookList;
    }

    @Override
    public AddressBookData getAddressBookDataById(Long id) {
        log.debug("Service: Fetching data for ID: {}", id);
        return addressBookList.stream()
                .filter(data -> data.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        addressBookData.setId(++counter);
        addressBookList.add(addressBookData);
        log.info("Service: Created new entry: {}", addressBookData);
        return addressBookData;
    }

    @Override
    public AddressBookData updateAddressBookData(Long id, AddressBookDTO addressBookDTO) {
        AddressBookData existingData = getAddressBookDataById(id);
        if (existingData != null) {
            existingData.setFirstName(addressBookDTO.getFirstName());
            existingData.setLastName(addressBookDTO.getLastName());
            existingData.setPhoneNumber(addressBookDTO.getPhoneNumber());
            existingData.setEmail(addressBookDTO.getEmail());
            log.info("Service: Updated entry for ID {}: {}", id, existingData);
        } else {
            log.warn("Service: Attempted to update non-existent entry with ID: {}", id);
        }
        return existingData;
    }

    @Override
    public void deleteAddressBookData(Long id) {
        boolean removed = addressBookList.removeIf(data -> data.getId().equals(id));
        if (removed) {
            log.info("Service: Deleted entry with ID: {}", id);
        } else {
            log.warn("Service: No entry found for deletion with ID: {}", id);
        }
    }
}