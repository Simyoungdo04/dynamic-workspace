package com.kh.web.ajax.model.dto;

public class ResponseDto {
	private String code;
	private String message;
	private Object date;
	
	public ResponseDto(String code, String message, Object date) {
		this.code = code;
		this.message = message;
		this.date = date;
	}
	
}
