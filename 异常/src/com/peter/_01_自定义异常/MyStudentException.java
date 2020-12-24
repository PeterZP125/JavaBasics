package com.peter._01_自定义异常;

public class MyStudentException extends RuntimeException {

    public MyStudentException() {

    }

    public MyStudentException(String msg) {
        super(msg);
    }
}
