package _02_Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        System.out.println("格式化前："+ date);
//        date -> str
        String dateStr = sdf.format(date);
        System.out.println("格式化后："+ dateStr);
//        str -> date
        Date parseDate = sdf.parse("2020-07-10 00:00:00");
        System.out.println(parseDate);
    }
}
