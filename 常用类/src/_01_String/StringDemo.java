package _01_String;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str1 = "abc";
        String str1_upper = "aBC";
        String str2 = "abe";
//        逐个比较
        System.out.println(str1.compareTo(str2));
//        忽略大小写比较
        System.out.println(str1.equalsIgnoreCase(str1_upper));

        String str3 = "I love java and programing";
//      从指定位置开始查找第一次出现的位置
        System.out.println(str3.indexOf('a', 11));
//      是否是执行字符串开始、结束
        System.out.println(str3.startsWith("a", 12));
        System.out.println(str3.endsWith("ming"));

//        String -> char[]
        char[] char1 = str1.toCharArray();
        System.out.println(char1);

//        String -> byte[]
        byte[] byte1= str1.getBytes("utf-8");
        System.out.println(Arrays.toString(byte1));
//        byte[] -> String
        System.out.println(new String(byte1, "utf-8"));
    }
}
