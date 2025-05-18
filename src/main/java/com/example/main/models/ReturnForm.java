package com.example.main.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReturnForm {
    private int id;
    private Date return_at;
    private List<ReturnItem> returnItems;

    public ReturnForm() {
        returnItems = new ArrayList<>();
    }

    public ReturnForm(int id, Date return_at) {
        this.id = id;
        this.return_at = return_at;
        returnItems = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReturnAt() {
        return return_at;
    }

    public void setReturnAt(Date return_at) {
        this.return_at = return_at;
    }

    public List<ReturnItem> getReturnItems() {
        return returnItems;
    }

    public void setReturnItems(List<ReturnItem> returnItems) {
        this.returnItems = returnItems;
    }

    public void addReturnItem(ReturnItem item) {
        this.returnItems.add(item);
    }
}
