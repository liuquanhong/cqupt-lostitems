package com.nmid.items.controller.messageConverter;



import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String s) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("日期转发异常");
        }
        return date;
    }
}
