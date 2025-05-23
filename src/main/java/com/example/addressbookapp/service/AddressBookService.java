package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {
	private List<AddressBookData> addressBookList = new ArrayList<>();
    private Long counter = 0L;
    
    @Override
    public List<AddressBookData> getAllAddressBookData() {
        return addressBookList;
    }
    
    @Override
    public AddressBookData getAddressBookDataById(Long id) {
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
        }
        return existingData;
    }
    
    @Override
    public void deleteAddressBookData(Long id) {
        addressBookList.removeIf(data -> data.getId().equals(id));
    }

}
