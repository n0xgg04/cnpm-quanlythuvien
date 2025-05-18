package com.example.main.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String name;
    private String author_name;
    private int year_published;
    private float price;
    private int amount;
    private String barcode_image_url;
    private String description;
    private List<BorrowItem> borrow_items;
    private List<ReturnItem> return_items;

    public Book() {
        borrow_items = new ArrayList<>();
        return_items = new ArrayList<>();
    }

    public Book(int id, String name, String author_name, int year_published,
                float price, int amount, String barcode_image_url, String description) {
        this.id = id;
        this.name = name;
        this.author_name = author_name;
        this.year_published = year_published;
        this.price = price;
        this.amount = amount;
        this.barcode_image_url = barcode_image_url;
        this.description = description;
        borrow_items = new ArrayList<>();
        return_items = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return author_name;
    }

    public void setAuthorName(String author_name) {
        this.author_name = author_name;
    }

    public int getYearPublished() {
        return year_published;
    }

    public void setYearPublished(int year_published) {
        this.year_published = year_published;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getBarcodeImageUrl() {
        return barcode_image_url;
    }

    public void setBarcodeImageUrl(String barcode_image_url) {
        this.barcode_image_url = barcode_image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BorrowItem> getBorrowItems() {
        return borrow_items;
    }

    public void setBorrowItems(List<BorrowItem> borrow_items) {
        this.borrow_items = borrow_items;
    }

    public List<ReturnItem> getReturnItems() {
        return return_items;
    }

    public void setReturnItems(List<ReturnItem> return_items) {
        this.return_items = return_items;
    }
}
