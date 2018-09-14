package com.timeline.pojos;

import java.sql.Timestamp;

public class Resources {
	
	private String url;
	private String type;
	private int catalofId;
	private Timestamp createTime;
	private Timestamp updateTime;
	
	public Resources(String url, String type, int catalofId, Timestamp createTime, Timestamp updateTime) {
		super();
		this.url = url;
		this.type = type;
		this.catalofId = catalofId;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCatalofId() {
		return catalofId;
	}
	public void setCatalofId(int catalofId) {
		this.catalofId = catalofId;
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
