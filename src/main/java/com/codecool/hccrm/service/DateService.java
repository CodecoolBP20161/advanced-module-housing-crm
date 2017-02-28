package com.codecool.hccrm.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by balag3 on 2017.02.21..
 */
@Service
public class DateService {

    public long time() {
        return new Date().getTime();
    }

    public String currentDate() {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        return form.format(new java.sql.Timestamp(time()));
    }

    public Calendar formatToCalendar(String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTime(sdf.parse(date));
        return cal;
    }
}
