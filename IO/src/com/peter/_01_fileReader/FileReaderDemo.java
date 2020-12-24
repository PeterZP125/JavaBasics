package com.peter._01_fileReader;

import java.io.*;

public class FileReaderDemo {
    public static void main(String[] args) {

        FileReader reader = null;
        FileWriter writer = null;
        try {
            File file = new File("E:\\TestFiles\\python.txt");
            reader = new FileReader(file);
            writer = new FileWriter("io\\python.txt");

            char[] buff = new char[1024];
            int len = 0;
            while ((len = reader.read(buff)) != -1) {
                writer.write(buff, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
