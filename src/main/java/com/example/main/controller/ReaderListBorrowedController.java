package com.example.main.controller;

import com.example.main.models.*;
import com.example.main.utils.DBConnection;
import com.example.main.views.ReaderListBorrowedBookFrm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReaderListBorrowedController {
    private final ReaderListBorrowedBookFrm view;
    private Connection connection;

    public ReaderListBorrowedController() {
        connection = DBConnection.getConnection();
        view = new ReaderListBorrowedBookFrm();
        view.addBackListener(new BackListener());
    }

    public void viewReaderListBorrowedBook(int bookId) {
        connection = DBConnection.getConnection();
        String sql = "SELECT bf.ID AS borrow_id, bf.borrow_at, r.ID AS reader_id, r.fullname, r.barcode_image_url, bi.amount, bi.status "
                +
                "FROM tblBorrowItem bi " +
                "JOIN tblBorrowForm bf ON bi.borrow_form_id = bf.ID " +
                "JOIN tblReadership r ON bf.readership_id = r.ID " +
                "WHERE bi.book_id = ? ";
        List<ReaderBorrowedBook> data = new ArrayList<>();
        Book book = null;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, bookId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (book == null) {
                    book = new Book();
                    book.setId(bookId);
                }
                // BorrowForm
                BorrowForm borrowForm = new BorrowForm();
                borrowForm.setId(rs.getInt("borrow_id"));
                borrowForm.setBorrowAt(rs.getTimestamp("borrow_at"));
                // Readership
                Readership reader = new Readership();
                reader.setId(rs.getInt("reader_id"));
                reader.setFullname(rs.getString("fullname"));
                reader.setBarcodeImageUrl(rs.getString("barcode_image_url"));
                // ReaderBorrowedBook
                int amount = rs.getInt("amount");
                boolean isReturned = rs.getInt("status") == 1;
                ReaderBorrowedBook rbb = new ReaderBorrowedBook();
                rbb.setBorrowForm(borrowForm);
                rbb.setReaderShip(reader);
                rbb.setAmount(amount);
                rbb.setIsReturned(isReturned);
                data.add(rbb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ReaderBorrowedBookHistory history = new ReaderBorrowedBookHistory();
        history.setBook(book);
        history.setReaderBorrowedBookTransaction(data);
        view.setData(history);
        view.setVisible(true);
    }

    class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.dispose();
        }
    }
}
