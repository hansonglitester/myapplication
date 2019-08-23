package com.hsl.cn.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

    /**
     *  指定日期,获取是当前时间是的第几周
     * @param Date date
     * @return
     */
    public static int getWeekOFYear(Date date){
        Calendar cal=Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(date);
        int week=cal.get(Calendar.WEEK_OF_YEAR);
        return week;
    }

    /**
     *  指定周的开始时间
     * @param Integer year,Integer week
     * @return
     */

    public static String getWeekStart(Integer year,Integer week){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        String beginDate = sdf.format(cal.getTime());
        return beginDate;
    }

    /**
     *  指定周的结束时间
     * @param Integer year,Integer week
     * @return
     */
    public static String getWeekEnd(Integer year,Integer week){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        String endDate = sdf.format(cal.getTime());
        return endDate;
    }

    /**
     *  某一年有多少个周
     * @param Integer year
     * @return
     */
    public static Integer getWeeksInYear(Integer year){
        Calendar cal=Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        return cal.getWeeksInWeekYear();
    }


    public static void main(String[] args) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(getWeekStart(2017,53));;
        System.out.println(getWeekEnd(2017,53));;
        Calendar cal=Calendar.getInstance();
        System.out.println(getWeeksInYear(2017));;
    }

}
