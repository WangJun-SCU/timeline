package com.timeline.common;

public class JsonResult {
	
	private int code; // 0：成功，其他：失败
	private String message;
	private Object body;
	
	public JsonResult() {
		
	}
	
	public JsonResult(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}
	
}
