package com.peter._01_buffer;

import java.nio.ByteBuffer;

public class BufferDemo {

    /*
    * mark:标记position位置，当返回时，可以返回至标记位;
      position：正在操作的数据的位置。
      limit：可操作数据大小
      capacity：缓冲区容量
    *
    *
    *
    *
    * */

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("存数据前");
        System.out.println("position:" + buffer.position());
        System.out.println("limit:" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());
        String data = "ABCDE";
//        存操作
        buffer.put(data.getBytes());
        System.out.println("存数据后");
        System.out.println("position:" + buffer.position());
        System.out.println("limit:" + buffer.limit());
        System.out.println("capacity:" + buffer.capacity());

//       从存操作切换为取操作
        buffer.flip();
    }
}
