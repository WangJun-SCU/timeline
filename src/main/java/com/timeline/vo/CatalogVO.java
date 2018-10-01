package com.timeline.vo;

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
public class CatalogVO {

	private int id;
	private String name;
	private String location;
	private long time;
	private String description;

}
