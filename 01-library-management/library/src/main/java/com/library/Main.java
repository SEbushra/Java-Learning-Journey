package com.library;

public class Main {
    public static void main(String[] args) {

        Library JUST_Library = new Library();
        Book book1 = new Book("Clean Code", "Robert Martin");
        Book book2 = new Book("Java Basics", "John Smith");

        JUST_Library.addBook(book1);
        JUST_Library.addBook(book2);
        JUST_Library.viewBooks();

        JUST_Library.searchBookByTitle("Java Basics");

    }
}