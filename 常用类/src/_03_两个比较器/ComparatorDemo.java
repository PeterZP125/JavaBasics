package _03_两个比较器;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        Phone p1 = new Phone("蓝魔", 1999.0);
        Phone p2 = new Phone("Huawei", 2559.0);
        Phone p3 = new Phone("OPPO", 4999.0);
        Phone p4 = new Phone("MI10", 4999.0);

        Phone[] phones = new Phone[]{p1, p2, p3,p4};

        Arrays.sort(phones, new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                int ret = Double.compare(o1.price, o2.price);
                if (ret == 0) {
                    return o1.brand.compareTo(o2.brand);
                } else {
                    return ret;
                }
            }
        });

        for (Phone phone : phones) {
            System.out.println(phone);
        }
    }
}

