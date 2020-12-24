package _03_两个比较器;

import java.util.Arrays;

public class ComparableDemo {
    public static void main(String[] args) {
        Phone p1 = new Phone("MI", 1999.0);
        Phone p2 = new Phone("REDMI", 399.0);
        Phone p3 = new Phone("IPhone", 4999.0);

        Phone[] phones = new Phone[]{p1, p2, p3};
        Arrays.sort(phones);
        for (Phone phone : phones) {
            System.out.println(phone);
        }
    }
}

class Phone implements Comparable{
    public String brand;
    public Double price;

    public Phone(String brand, Double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Phone){
            Phone oo = (Phone) o;
            if(this.price > oo.price){
                return 1;
            }else if(this.price < oo.price){
                return -1;
            }else{
                return 0;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
