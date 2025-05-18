package com.example.main.models;

public class ReturnItem {
    private int id;
    private ReturnForm return_form;
    private Book book;
    private int fine;
    private int amount;

    public ReturnItem() {
    }

    public ReturnItem(int id, ReturnForm return_form, Book book, int fine, int amount) {
        this.id = id;
        this.return_form = return_form;
        this.book = book;
        this.fine = fine;
        this.amount = amount;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReturnForm getReturnForm() {
        return return_form;
    }

    public void setReturnForm(ReturnForm return_form) {
        this.return_form = return_form;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
