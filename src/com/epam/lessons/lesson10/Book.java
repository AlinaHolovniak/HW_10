package com.epam.lessons.lesson10;

import java.io.Serializable;

public class Book implements Serializable {
    private int id;
    private String name;
    private String author;
    private String publishHouse;
    private int yearOfPublication;
    private int numberOfPages;
    private double price;

    public Book(int id, String name, String author, String publishHouse, int yearOfPublication, int numberOfPages, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishHouse = publishHouse;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
        this.price = price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(String publishHouse) {
        this.publishHouse = publishHouse;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", author='" + this.author + '\'' +
                ", publishHouse='" + this.publishHouse + '\'' +
                ", yearOfPublication=" + this.yearOfPublication +
                ", numberOfPages=" + this.numberOfPages +
                ", price=" + this.price +
                '}';
    }
}