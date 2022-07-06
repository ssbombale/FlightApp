package com.user.util;

import java.text.Format;
import java.text.SimpleDateFormat;

public class DateUtil {

	public static String getDay(String searchdate)  {
		String days = "";
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Format f = new SimpleDateFormat("EEEE");
		 days = f.format(sdf.parseObject(searchdate));
		System.out.println("Day Name: " + days);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return days;
	}

}
