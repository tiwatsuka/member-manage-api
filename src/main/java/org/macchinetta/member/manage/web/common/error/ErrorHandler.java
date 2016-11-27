package org.macchinetta.member.manage.web.common.error;

import java.util.HashMap;
import java.util.Map;

import org.macchinetta.member.manage.web.common.error.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler{

	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Map<String, String> badRequest(BadRequestException exception){
		Map<String, String> error = new HashMap<>();
		error.put("message", exception.getMessage());
		return error; 
	};

}
