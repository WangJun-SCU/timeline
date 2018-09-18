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
public class Catalog {
	
	private String name;
	private String location;
	private Timestamp time;
	private String description;
	private Timestamp createTime;
	private Timestamp updateTime;

}
