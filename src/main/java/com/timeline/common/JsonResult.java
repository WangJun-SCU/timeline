package com.timeline.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Setter
@Getter
public class JsonResult {
	
	private int code; // 0：成功，其他：失败
	private String message;
	private Object body;
	
	public JsonResult(RetCode retCode) {
		super();
		this.code = retCode.getCode();
		this.message = retCode.getMessage();
	}

}
