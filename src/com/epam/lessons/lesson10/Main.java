package com.epam.lessons.lesson10;
import java.util.Scanner;

import static com.epam.lessons.lesson10.SaveAndReadFile.readFile;
import static com.epam.lessons.lesson10.SaveAndReadFile.saveFile;
import static com.epam.lessons.lesson10.Validator.validateDoubleNumber;
import static com.epam.lessons.lesson10.Validator.validateEmptyString;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Books books = new Books(9);

        Book[] booksList = new Book[]{
                new Book(1, " Decision Points", " George W. Bush", " Crown", 2011, 454, 133.50),
                new Book(2, " Killing the Rising Sun", " Martin Dugard", " Holt", 1999, 613, 200.44),
                new Book(3, " The Glass Castle", " Jeannette Walls", " Scribner", 1981, 674, 99.99),
                new Book(4, " Sisters First", " Jenna Bush Hager", " Central", 2001, 233, 45.70),
                new Book(5, " Grant", " Ron Chernow", " Penguin Press", 1991, 124, 33.50),
        };

        for (Book book : booksList) {
            books.addBook(book);
        }
        books.viewBooks();

        try {
            System.out.println("Enter increase of the price in percent for the books ");
            String priceCoefficient = scanner.nextLine();
            validateDoubleNumber(priceCoefficient);
            books.changePrice(Double.parseDouble(priceCoefficient));
            books.viewBooks();
        } catch (ValidationException e) {
            System.out.println("Change price failed due to " + e.getMessage());
        }

        try {
            System.out.println("Enter author's name");
            String author = scanner.nextLine();
            Books booksByAuthor = books.findBooksByAuthor(author);

            if (booksByAuthor.getLength() > 0) {
                System.out.println("Found books:");
                booksByAuthor.viewBooks();
            } else {
                System.out.println("Books not found");
            }
        } catch (ValidationException e) {
            System.out.println("Find book by author failed due to " + e.getMessage());
        }

        try {
            System.out.println("Enter the year of the publishing ");
            Books booksByYear = books.findBookByYear(scanner.nextInt());

            if (booksByYear.getLength() > 0) {
                System.out.println("Found books:");
                booksByYear.viewBooks();
            } else {
                System.out.println("Books not found");
            }
        } catch (ValidationException e) {
            System.out.println("Find book by year failed due to " + e.getMessage());
        }
        System.out.println("Sorting by Price:");
        books.sortByPrice();
        books.viewBooks();
        System.out.println("Sorting by Author:");
        books.sortByAuthor();
        books.viewBooks();
        System.out.println("Sorting by Publish House:");
        books.sortByPublishHouse();
        books.viewBooks();
        readFile();
        saveFile(books.toString());
        BooksSerializator serializator = new BooksSerializator();
        try {
            System.out.println("Enter a file name ");
            String fileName;
            fileName = scanner.nextLine();
            validateEmptyString(fileName);
            Book book = new Book(1, " Decision Points", " George W. Bush", " Crown", 2011, 454, 133.50);
            serializator.serialization(book, fileName);
            System.out.println("Data serialized");
        } catch (ValidationException e) {
            System.out.println("Serialization failed, please enter a file name");
        }
        try {
            System.out.println("Enter a file name ");
            String fileName = scanner.nextLine();
            validateEmptyString(fileName);
            Book deserializeBook = serializator.deserealization(fileName);
            System.out.println(deserializeBook.toString());
        } catch (ValidationException ex) {
            System.out.println("Incorrect file name, please enter a correct name");
        }
    }
}