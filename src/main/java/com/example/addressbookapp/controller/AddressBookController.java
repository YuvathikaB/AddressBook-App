package com.example.addressbookapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("Hello from Address Book App!", HttpStatus.OK);
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> sayHelloByName(@PathVariable String name) {
        return new ResponseEntity<>("Hello " + name + " from Address Book App!", HttpStatus.OK);
    }

    @PostMapping("/hello")
    public ResponseEntity<String> postHello(@RequestBody String message) {
        return new ResponseEntity<>("Received POST: " + message, HttpStatus.CREATED);
    }

    @PutMapping("/hello/{id}")
    public ResponseEntity<String> putHello(@PathVariable Long id, @RequestBody String message) {
        return new ResponseEntity<>("Updated ID " + id + " with: " + message, HttpStatus.OK);
    }

    @DeleteMapping("/hello/{id}")
    public ResponseEntity<String> deleteHello(@PathVariable Long id) {
        return new ResponseEntity<>("Deleted ID: " + id, HttpStatus.NO_CONTENT);
    }

}
