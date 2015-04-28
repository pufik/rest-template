package com.xdev.template.rest.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xdev.template.rest.resource.Message;

@RestController
public class SystemController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(SystemController.class);

	@RequestMapping(value = "/error")
	public ResponseEntity<Message> handleError(HttpServletRequest request) {
		Throwable error = (Throwable) (request.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
		String errorMessage = String.valueOf(request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
		String errorCode = String.valueOf(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
		int statusCode = Integer.parseInt(errorCode);

		LOG.error("Error handled by error page", error);

		return new ResponseEntity<>(Message.Builder.error(errorMessage).code(statusCode).build(), HttpStatus.valueOf(statusCode));
	}
}
