package com.xdev.template.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xdev.template.rest.resource.Message;

@RestController
public class SystemController extends BaseController {

	@RequestMapping(method = RequestMethod.GET)
	public Message sayHello() {
		Message message = new Message();
		message.setMessage("Hello world!!!");

		return message;
	}

	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public void throwException() {
		throw new RuntimeException();
	}
}
