package com.example.main.models;

public class TopBorrowedBookInfo {
    private int rank;
    private Book book;
    private int borrowingCount;

    public TopBorrowedBookInfo() {
    }

    public TopBorrowedBookInfo(int rank, Book book, int borrowingCount) {
        this.rank = rank;
        this.book = book;
        this.borrowingCount = borrowingCount;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getBorrowingCount() {
        return borrowingCount;
    }

    public void setBorrowingCount(int borrowingCount) {
        this.borrowingCount = borrowingCount;
    }
}
