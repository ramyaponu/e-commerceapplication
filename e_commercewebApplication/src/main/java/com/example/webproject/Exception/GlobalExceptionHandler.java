package com.example.webproject.Exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OrderException.class)
	public ResponseEntity<ErrorInformation> handlerForOrderException(OrderException e){
    	ErrorInformation er=new ErrorInformation();
    	er.setSatusCode(HttpStatus.BAD_REQUEST.value());
    	er.setOccuredAt(LocalDateTime.now());
    	er.setErrorMessage(e.getMessage());
    	
		return new ResponseEntity<ErrorInformation>(er,HttpStatus.BAD_REQUEST);
		
	}
    @ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInformation> generaLException(Exception e) {

		ErrorInformation er = new ErrorInformation();
		er.setOccuredAt(LocalDateTime.now());
		// System.out.println("printing message " + e.toString());
		er.setErrorMessage("Internal server error  occured  Exception:" + e.toString());
		er.setSatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ErrorInformation>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
    @ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInformation> methdArgumentInvalidException(MethodArgumentNotValidException e) {
		System.out.println("handled by Manve");
		ErrorInformation er = new ErrorInformation();
		er.setOccuredAt(LocalDateTime.now());
		er.setSatusCode(HttpStatus.BAD_REQUEST.value());
		BindingResult br = e.getBindingResult();
		List<ObjectError> lor = br.getAllErrors();
		Stream<String> allErrorMessages = lor.stream().map((ObjectError e1) -> e1.getDefaultMessage());
		String errMessage = allErrorMessages.collect(Collectors.joining(","));

		er.setErrorMessage(errMessage);
		return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);

	}

}
