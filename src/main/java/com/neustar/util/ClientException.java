package com.neustar.util;

public class ClientException extends Exception {

	public ClientException(String message) {
		super(message);
	}

	public ClientException(String message, Exception ex) {
		super(message, ex);
	}
}