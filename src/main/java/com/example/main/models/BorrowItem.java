package com.example.main.models;

public class BorrowItem {
    private int id;
    private BorrowForm borrow_form;
    private Book book;
    private int amount;

    public BorrowItem() {
    }

    public BorrowItem(int id, BorrowForm borrow_form, Book book, int amount) {
        this.id = id;
        this.borrow_form = borrow_form;
        this.book = book;
        this.amount = amount;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BorrowForm getBorrowForm() {
        return borrow_form;
    }

    public void setBorrowForm(BorrowForm borrow_form) {
        this.borrow_form = borrow_form;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
