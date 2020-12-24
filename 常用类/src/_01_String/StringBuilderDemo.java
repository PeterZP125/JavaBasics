package _01_String;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(30);

        //追加字符串
        sb.append("abc");
        System.out.println(sb);
//        删除字符
        sb.delete(0, 2);
        System.out.println(sb);
        sb.append("天青色等烟雨，而我在等你");
//        替换
        sb.replace(0, 2,"哈哈");
        System.out.println(sb);
//        插入
        sb.insert(8, "周杰伦");
        System.out.println(sb);
//        反转
        sb.reverse();
        System.out.println(sb);
//        查首次出现位置
        System.out.println(sb.indexOf("我"));
//        查指定位置字符
        System.out.println(sb.charAt(4));
//        设置指定位置字符
        sb.setCharAt(10, 'z');
        System.out.println(sb);

    }
}
