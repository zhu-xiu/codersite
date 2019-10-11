package com.edm.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ChinHeng-Chu
 * @Description
 * @create 2019-10-10 10:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

	private Boolean flag;
	private Integer code;
	private String message;
	private Object data;

	public Result(Boolean flag, Integer code, String message) {
		this.flag = flag;
		this.code = code;
		this.message = message;
	}
}

