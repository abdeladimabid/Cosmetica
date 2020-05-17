package com.cosmetica.exceptions;

public class DuplicateKeyException extends RuntimeException {

	private static final long serialVersionUID = -7858869555553243875L;

	public  DuplicateKeyException(String string) {
		
    	  super("Product with Referance " + string +" already exists in stock, try modifying its quantity. or provide a new Referance if you would like to add a new product");
	}

}
