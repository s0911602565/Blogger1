package com.lee.springbootworkspaceblogger.util.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    public static int age(String birthday) {//算出年齡
        if("".equals(birthday)) return 0;
        long old = 0;
        long now = 0;
        try {
            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            Date date = df.parse(birthday);
            Date currentTime = new Date();
            now = currentTime.getTime() - date.getTime();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) (now / (365 * 24 * 60 * 60 * 1000L));
    }

}
