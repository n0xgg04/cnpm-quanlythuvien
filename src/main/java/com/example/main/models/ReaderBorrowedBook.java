package com.example.main.models;

public class ReaderBorrowedBook {
    private BorrowForm borrowForm;
    private Readership readerShip;
    private int amount;
    private boolean isReturned;

    public ReaderBorrowedBook() {
    }

    public ReaderBorrowedBook(BorrowForm borrowForm, Readership readerShip, int amount, boolean isReturned) {
        this.borrowForm = borrowForm;
        this.readerShip = readerShip;
        this.amount = amount;
        this.isReturned = isReturned;
    }

    public BorrowForm getBorrowForm() {
        return borrowForm;
    }

    public void setBorrowForm(BorrowForm borrowForm) {
        this.borrowForm = borrowForm;
    }

    public Readership getReaderShip() {
        return readerShip;
    }

    public void setReaderShip(Readership readerShip) {
        this.readerShip = readerShip;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setIsReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }
}
