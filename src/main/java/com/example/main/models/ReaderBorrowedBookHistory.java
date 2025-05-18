package com.example.main.models;

import java.util.ArrayList;
import java.util.List;

public class ReaderBorrowedBookHistory {
    private Book book;
    private List<ReaderBorrowedBook> readerBorrowedBookTransaction;

    public ReaderBorrowedBookHistory() {
    }

    public ReaderBorrowedBookHistory(Book book, ArrayList<ReaderBorrowedBook> readerBorrowedBookTransaction) {
        this.readerBorrowedBookTransaction = readerBorrowedBookTransaction;
        this.book = book;
    }

    public List<ReaderBorrowedBook> getReaderBorrowedBookTransaction() {
        return readerBorrowedBookTransaction;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setReaderBorrowedBookTransaction(List<ReaderBorrowedBook> readerBorrowedBookTransaction) {
        this.readerBorrowedBookTransaction = readerBorrowedBookTransaction;
    }
}
