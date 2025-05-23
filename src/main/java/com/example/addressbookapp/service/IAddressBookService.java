package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;

import java.util.List;

public interface IAddressBookService {
	List<AddressBookData> getAllAddressBookData();
    AddressBookData getAddressBookDataById(Long id);
    AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);
    AddressBookData updateAddressBookData(Long id, AddressBookDTO addressBookDTO);
    void deleteAddressBookData(Long id);

}
