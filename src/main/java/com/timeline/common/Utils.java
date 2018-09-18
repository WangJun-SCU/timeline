package com.timeline.common;

import java.sql.Timestamp;

public class Utils {
	
	/*
	 * 时间戳转Timestamp类型
	 */
	public static Timestamp long2Timestamp(long time) {
		return new Timestamp(time);
	}
	
	/*
	 * Timestamp类型转时间戳
	 */
	public static long timestamp2Long(Timestamp time) {
		return time.getTime();
	}

}
