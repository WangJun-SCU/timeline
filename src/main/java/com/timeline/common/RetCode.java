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
	ERROR_PARAM       (1001, "params error");
	
	private int code;
	private String message;
	
}
