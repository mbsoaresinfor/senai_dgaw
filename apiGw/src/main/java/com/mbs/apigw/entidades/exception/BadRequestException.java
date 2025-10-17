package com.mbs.apigw.entidades.exception;

public class BadRequestException extends RuntimeException{
	 public BadRequestException(String message) {
	        super(message);
	    }
}
