package com.hsl.cn.common.utils;

import java.util.Calendar;

public class WeekUtils1 {

    public static void main(String[] args) {

        WeekUtils1 cd = new WeekUtils1();
        System.out.println("开始时间: " + cd.getStartDayOfWeekNo(2015,47) );
        System.out.println("结束时间:" + cd.getEndDayOfWeekNo(2015,47) );

    }

    /**
     * get first date of given month and year
     * @param year
     * @param month
     * @return
     */
    public String getFirstDayOfMonth(int year,int month){
        String monthStr = month < 10 ? "0" + month : String.valueOf(month);
        return year + "-"+monthStr+"-" +"01";
    }

    /**
     * get the last date of given month and year
     * @param year
     * @param month
     * @return
     */
    public String getLastDayOfMonth(int year,int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR , year);
        calendar.set(Calendar.MONTH , month - 1);
        calendar.set(Calendar.DATE , 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR , -1);
        return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" +
                calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * get Calendar of given year
     * @param year
     * @return
     */
    private Calendar getCalendarFormYear(int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        return cal;
    }

    /**
     * get start date of given week no of a year
     * @param year
     * @param weekNo
     * @return
     */
    public String getStartDayOfWeekNo(int year,int weekNo){
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +
                cal.get(Calendar.DAY_OF_MONTH);

    }

    /**
     * get the end day of given week no of a year.
     * @param year
     * @param weekNo
     * @return
     */
    public String getEndDayOfWeekNo(int year,int weekNo){
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +
                cal.get(Calendar.DAY_OF_MONTH);
    }
}