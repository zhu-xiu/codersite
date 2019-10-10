package com.edm.base.controller;

import com.edm.common.entity.Result;
import com.edm.common.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ChinHeng-Chu
 * @Description
 * @create 2019-10-10 14:59
 */
@ControllerAdvice
public class BaseExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result error(Exception e){
		e.printStackTrace();
		return new Result(false, StatusCode.ERROR,e.getMessage());
	}
}

