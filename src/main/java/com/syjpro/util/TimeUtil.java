package com.syjpro.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static String getTime() {
		Date dt = new Date();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss");//设置日期格式
		return df.format(dt);// new Date()为获取当前系统时间
	}
	public static String getTime(Date dt) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss");//设置日期格式
		return df.format(dt);// new Date()为获取当前系统时间
	}
}
