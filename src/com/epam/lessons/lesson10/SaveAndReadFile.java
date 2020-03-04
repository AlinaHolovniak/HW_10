package com.epam.lessons.lesson10;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAndReadFile {
    public static void readFile() {
        FileInputStream fis = null;
        int i = 0;

        try {
            fis = new FileInputStream("t.txt");
            fis.read();
            while ((i = fis.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveFile(String toSave) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("t.txt", true);
            fw.write(toSave);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}