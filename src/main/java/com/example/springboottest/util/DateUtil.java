package com.example.springboottest.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    //add parseDate method
    public static Date parseDate(String holidayDate) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(holidayDate);
        } catch (Exception e) {
            return null;
        }
    }
}
