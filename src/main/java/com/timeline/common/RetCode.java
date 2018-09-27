package com.timeline.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public enum RetCode {

	SUCCESS           (0, "success"),
	ERROR_PARAM       (1001, "params error"),
	ERROR_HTTP_PARAM  (1002, "http params error"),
	ERROR_UPLOAD      (1003, "upload failed");
	
	private int code;
	private String message;
	
}
