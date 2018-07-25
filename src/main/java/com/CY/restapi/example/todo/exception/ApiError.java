package com.CY.restapi.example.todo.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.CUSTOM, property = "error", visible = true)
class ApiError {
	
	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	
	private ApiError() {
		timestamp = LocalDateTime.now();
	}
	
	ApiError(HttpStatus status) {
		this();
		this.status = status;
	}
	
	ApiError(HttpStatus status, String message) {
		this();
		this.status = status;
		this.message = message;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public String getMessage() {
		return message;
	}
}