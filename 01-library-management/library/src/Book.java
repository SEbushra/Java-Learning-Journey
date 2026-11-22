package com.library;

public class Book {
    private static int nextId = 0;
    private final int id;
    private String title;
    private String author;
    private BookStatus status;

    Book(String title, String author) {
        this(title, author, BookStatus.AVAILABLE);

    }

    Book(String title, String author, BookStatus status) {
        if (title == null || author == null || status == null || title.isBlank() || author.isBlank()) {
            throw new IllegalArgumentException("Title, author and status must be valid");
        }
        this.id = nextId++;
        this.title = title;
        this.author = author;
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookStatus getStatus() {
        return status;
    }

    void borrowTheBook() {
        if (this.status == BookStatus.AVAILABLE) {
            this.status = BookStatus.BORROWED;
        } else {
            throw new IllegalStateException("Book is already borrowed");
        }
    }

    void returnTheBook() {
        if (this.status == BookStatus.BORROWED) {
            this.status = BookStatus.AVAILABLE;
        } else {
            throw new IllegalStateException("Book is not borrowed by you");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Book)) {
            return false;
        }

        Book other = (Book) obj;
        return (this.title.equals(other.title) && this.author.equals(other.author));
    }

}
