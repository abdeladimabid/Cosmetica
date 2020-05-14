package com.cosmetica.exceptions;

public class ItemDontExistException extends RuntimeException {

	private static final long serialVersionUID = -7858869555653243875L;

	public  ItemDontExistException(String string) {
		
    	  super("Item with Referance " + string +" Doesn't exists in stock, Or may be expired. try with a diffrent referance!");
	}
	
	public  ItemDontExistException(int string) {
		
		super("Item with Referance " + string +" Doesn't exists in stock, Or may be expired. try with a diffrent referance!");
	}

}
