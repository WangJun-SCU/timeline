package com.timeline.common;

import java.sql.Timestamp;

public class Utils {
	
	public static Timestamp long2Timestamp(long time) {
		return new Timestamp(time);
	}

}
