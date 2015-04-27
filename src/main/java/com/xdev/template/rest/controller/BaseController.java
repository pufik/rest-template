package com.xdev.template.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xdev.template.rest.resource.Message;

public abstract class BaseController {

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Message> handleException(Exception exception) {
		return new ResponseEntity<Message>(Message.Builder.error(exception.getMessage()).code(HttpStatus.BAD_REQUEST.value()).build(), HttpStatus.BAD_REQUEST);
	}
}