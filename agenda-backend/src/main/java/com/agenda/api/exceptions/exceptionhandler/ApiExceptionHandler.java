package com.agenda.api.exceptions.exceptionhandler;

import java.time.Instant;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.agenda.api.exceptions.AuthorizationException;
import com.agenda.api.exceptions.BusinessRuleException;
import com.agenda.api.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var statusHttp = status.value();
		var timestamp = Instant.now();
		var title = "Um ou mais campos estão inválidos. "
				+ "Faça o preenchimento correto e tente novamente";
		var path = request.getDescription(false).substring(4);
		var body = new ResponseApi(statusHttp, timestamp, title, path);
		var fields = new ArrayList<ResponseApi.Field>();
		
		for (ObjectError erro : ex.getBindingResult().getAllErrors()) {
			
			var name = ((FieldError)erro).getField();
			var message = erro.getDefaultMessage();
			
			fields.add(new ResponseApi.Field(name, message));
		}
		
		body.setFields(fields);
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
	@ExceptionHandler(BusinessRuleException.class)
	public ResponseEntity<Object> handleBusinessError(BusinessRuleException ex, WebRequest request){
		var status = HttpStatus.UNPROCESSABLE_ENTITY;
		var path = request.getDescription(false).substring(4); //try casting for HttpServletRequest
		var body = new ResponseApi(status.value(), Instant.now(), ex.getMessage(), path);
		return super.handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
		
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseApi> resouceNotFound(ResourceNotFoundException ex, 
			HttpServletRequest request){		
		
		var status = HttpStatus.NOT_FOUND;
		var path = request.getRequestURI();
		var err = new ResponseApi(status.value(), Instant.now(), ex.getMessage(), path);
		
		return ResponseEntity.status(status).body(err);	
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ResponseApi> resouceNotFound(AuthorizationException ex, 
			HttpServletRequest request){		
		
		var status = HttpStatus.FORBIDDEN;
		var path = request.getRequestURI();
		var err = new ResponseApi(status.value(), Instant.now(), ex.getMessage(), path);
		
		return ResponseEntity.status(status).body(err);	
	}
	
}
