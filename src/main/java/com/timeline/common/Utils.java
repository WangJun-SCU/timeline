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
	
	/*
	 * 生成一个随机文件名：时间戳_4位随机数.后缀
	 */
	public static String newFileName(String originalFilename) {
		String filePostfix = originalFilename.substring(originalFilename.lastIndexOf("."));
		String time = System.currentTimeMillis() + "";
		// [1000,10000)
		int num = (int) (Math.random() * 9000 + 1000);
		return time + "_" + num + filePostfix;
	}

}
