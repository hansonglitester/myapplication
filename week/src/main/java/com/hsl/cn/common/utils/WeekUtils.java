package com.hsl.cn.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeekUtils {

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

    public static Date getWeekStart(Integer year,Integer week){

        Calendar cal=Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     *  指定周的结束时间
     * @param Integer year,Integer week
     * @return
     */
    public static Date getWeekEnd(Integer year,Integer week){
        Calendar cal=Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        return cal.getTime();
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


    /**
     *  指定周的结束时间
     * @param Integer year,Integer week
     * @return
     */
    public static List<Date> getWeekDayList(Integer year, Integer week) throws ParseException {

        Calendar cal=Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, week);
        cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        List<Date> weeklist=new ArrayList <>();
        for (int i=0;i<7;i++){
            weeklist.add(cal.getTime());
            cal.add(cal.DATE,1);//增加一天
        }
        return weeklist;

    }

    public static Integer getYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);

    }

    public static Integer getMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);

    }

    //日期格式转换

    public static String DateToString(String pattern,Date date) throws ParseException {

        SimpleDateFormat sdf =new SimpleDateFormat(pattern);
        return sdf.format(date);

    }





    public static void main(String[] args) throws ParseException {
        Date nowDate= new Date();
        System.out.println( getWeekStart(getYear(nowDate),getWeekOFYear(nowDate)));

      //  List<Date> weeklist=getWeekDayList(getYear(nowDate),getWeekOFYear(nowDate));
        List<Date> weeklist=getWeekDayList(2019,4);
        for (Date date :weeklist){
            System.out.println(DateToString("yyy-M-d",date));
        }
    }

}
