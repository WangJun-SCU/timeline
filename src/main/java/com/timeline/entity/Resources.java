package com.timeline.entity;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Resources {
	
	private String url;
	private int type;
	private int catalogId;
	private Timestamp createTime;
	private Timestamp updateTime;
	
}
