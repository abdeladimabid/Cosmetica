package com.cosmetica.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class CosmeticaException extends RuntimeException {
    public  CosmeticaException(int id) {
		
    	  super("id not found: " + id);
	}
    
    public  CosmeticaException(String username) {
		
  	  super("username not found: " + username);
	}

}
