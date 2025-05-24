package com.example.addressbookapp.exception;

import com.example.addressbookapp.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j; 
import org.springframework.http.*;
import org.springframework.validation.ObjectError; 
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j 
public class AddressbookExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		log.error("Validation Error: {}", exception.getMessage());
		List<String> errorMessages = exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage) 
                .collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Validation Failed", errorMessages);
		return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	}

}
