package com.timeline.pojos;

import java.sql.Timestamp;

public class Catalog {
	
	private String name;
	private String location;
	private Timestamp time;
	private String desc;
	private Timestamp createTime;
	private Timestamp updateTime;
	
	public Catalog() {
		
	}
	
	public Catalog(String name, String location, Timestamp time, String desc, Timestamp createTime,
			Timestamp updateTime) {
		super();
		this.name = name;
		this.location = location;
		this.time = time;
		this.desc = desc;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}
