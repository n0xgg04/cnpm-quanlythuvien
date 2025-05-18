package com.example.main.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Readership {
    private int id;
    private String fullname;
    private Date dob;
    private String address;
    private String phone_number;
    private String barcode_image_url;
    private List<BorrowForm> borrow_forms;
    private List<ReturnForm> return_forms;

    public Readership() {
        borrow_forms = new ArrayList<>();
        return_forms = new ArrayList<>();
    }

    public Readership(int id, String fullname, Date dob, String address,
                      String phone_number, String barcode_image_url) {
        this.id = id;
        this.fullname = fullname;
        this.dob = dob;
        this.address = address;
        this.phone_number = phone_number;
        this.barcode_image_url = barcode_image_url;
        borrow_forms = new ArrayList<>();
        return_forms = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getBarcodeImageUrl() {
        return barcode_image_url;
    }

    public void setBarcodeImageUrl(String barcode_image_url) {
        this.barcode_image_url = barcode_image_url;
    }

    public List<BorrowForm> getBorrowForms() {
        return borrow_forms;
    }

    public void setBorrowForms(List<BorrowForm> borrow_forms) {
        this.borrow_forms = borrow_forms;
    }

    public List<ReturnForm> getReturnForms() {
        return return_forms;
    }

    public void setReturnForms(List<ReturnForm> return_forms) {
        this.return_forms = return_forms;
    }
}

