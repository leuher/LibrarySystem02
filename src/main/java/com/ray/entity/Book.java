package com.ray.entity;

public class Book {
    private Long id;

    private String bookName;

    private String bookWriter;

    private String bookPublisher;

    private Long bookIsrent;

    private String bookPerson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter == null ? null : bookWriter.trim();
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher == null ? null : bookPublisher.trim();
    }

    public Long getBookIsrent() {
        return bookIsrent;
    }

    public void setBookIsrent(Long bookIsrent) {
        this.bookIsrent = bookIsrent;
    }

    public String getBookPerson() {
        return bookPerson;
    }

    public void setBookPerson(String bookPerson) {
        this.bookPerson = bookPerson == null ? null : bookPerson.trim();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookWriter='" + bookWriter + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookIsrent=" + bookIsrent +
                ", bookPerson='" + bookPerson + '\'' +
                '}';
    }
}