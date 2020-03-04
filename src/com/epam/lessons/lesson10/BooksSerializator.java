package com.epam.lessons.lesson10;

import java.io.*;

public class BooksSerializator {
    public boolean serialization(Book book, String fileName) {
        boolean bool = false;
        File fileToBeSaved = new File(fileName);
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(fileToBeSaved);
            if (fos != null) {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(book);
                bool = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bool;
    }

    public Book deserealization(String fileName) {
        File fileToBeSaved = new File(fileName);
        ObjectInputStream ois = null;
        Book book = null;
        try {
            FileInputStream fis = new FileInputStream(fileToBeSaved);
            if (fis != null) {
                ois = new ObjectInputStream(fis);
                book = (Book) ois.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return book;
    }
}