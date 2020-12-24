package _02_Date;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        int date_of_month = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(date_of_month);
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(day_of_week);
//        获取当前日期
        Date time = calendar.getTime();
        System.out.println(time);

        Date curDate= new Date();
        calendar.setTime(curDate);
//        对日历类型做计算
        calendar.add(Calendar.MONTH, 2);
        System.out.println(calendar.getTime());
    }
}
