package com.example.addressbookapp.repository;

import com.example.addressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository 
public interface AddressBookRepository extends JpaRepository<AddressBookData, Long>{

}
