package com.example.main.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowForm {
    private int id;
    private Date borrow_at;
    private List<BorrowItem> borrowItems;

    public BorrowForm() {
        borrowItems = new ArrayList<>();
    }

    public BorrowForm(int id, Date borrow_at) {
        this.id = id;
        this.borrow_at = borrow_at;
        borrowItems = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBorrowAt() {
        return borrow_at;
    }

    public void setBorrowAt(Date borrow_at) {
        this.borrow_at = borrow_at;
    }

    public List<BorrowItem> getBorrowItems() {
        return borrowItems;
    }

    public void setBorrowItems(List<BorrowItem> borrowItems) {
        this.borrowItems = borrowItems;
    }

    public void addBorrowItem(BorrowItem item) {
        this.borrowItems.add(item);
    }
}
