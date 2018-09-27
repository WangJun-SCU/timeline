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
	
	private int id;
	private String name;
	private String location;
	private Timestamp time;
	private String description;
	private Timestamp createTime;
	private Timestamp updateTime;
	
	public Catalog(String name, String location, Timestamp time, String description, Timestamp createTime,
			Timestamp updateTime) {
		super();
		this.name = name;
		this.location = location;
		this.time = time;
		this.description = description;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	
}
