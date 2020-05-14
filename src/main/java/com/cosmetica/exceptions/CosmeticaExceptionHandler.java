package com.cosmetica.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;





public class CosmeticaExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(CosmeticaException.class)
	public ResponseEntity<CosmeticaError> customHandleNotFound(Exception ex, WebRequest request) {
		CosmeticaError error = new CosmeticaError();
		  error.setError(ex.getMessage());
		  error.setStatus(HttpStatus.NOT_FOUND.value());

	        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	  }

}
