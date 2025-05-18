package com.example.main.controller;

import com.example.main.models.Book;
import com.example.main.models.PeriodTime;
import com.example.main.models.TopBorrowedBookInfo;
import com.example.main.models.TopBorrowedBookStatistic;
import com.example.main.utils.DBConnection;
import com.example.main.views.SelectPeriodFrm;
import com.example.main.views.TopBorrowedBookStatisticFrm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TopBorrowedBookStatisticController {
    private Connection connection;
    private SelectPeriodFrm selectPeriodFrm;
    private TopBorrowedBookStatisticFrm topBorrowedBookStatisticFrm;
    private ReaderListBorrowedController readerListController;

    public TopBorrowedBookStatisticController() {
        connection = DBConnection.getConnection();
        readerListController = new ReaderListBorrowedController();
        selectPeriodFrm = new SelectPeriodFrm();
        selectPeriodFrm.addViewStatsListener(new ViewStatsListener());
        selectPeriodFrm.addHomeListener(new BackToHomeListener());
        selectPeriodFrm.setVisible(true);
    }

    private void viewStatistics(PeriodTime periodTime) {
        if (periodTime.getStartDate() == null || periodTime.getEndDate() == null) {
            selectPeriodFrm.showDialog("Vui lòng chọn đầy đủ ngày bắt đầu và kết thúc", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (periodTime.getStartDate().after(periodTime.getEndDate())) {
            selectPeriodFrm.showDialog("Ngày bắt đầu phải trước ngày kết thúc", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        TopBorrowedBookStatistic statistic = getTopBorrowedBookStatistic(periodTime);
        selectPeriodFrm.dispose();
        topBorrowedBookStatisticFrm = new TopBorrowedBookStatisticFrm();
        topBorrowedBookStatisticFrm.setStatisticData(statistic);
        topBorrowedBookStatisticFrm.addBackListener(e -> {
            selectPeriodFrm.setVisible(true);
            topBorrowedBookStatisticFrm.dispose();
        });
        topBorrowedBookStatisticFrm.addBookClickListener(new BookClickListener());
        topBorrowedBookStatisticFrm.setVisible(true);
    }

    private TopBorrowedBookStatistic getTopBorrowedBookStatistic(PeriodTime periodTime) {
        List<TopBorrowedBookInfo> topList = new ArrayList<>();
        String sql = "SELECT b.ID, b.name, b.author_name, b.year_published, b.price, b.barcode_image_url, b.description, "
                +
                "COUNT(bi.id) AS borrow_count " +
                "FROM tblBook b " +
                "JOIN tblBorrowItem bi ON b.ID = bi.book_id " +
                "GROUP BY b.ID " +
                "ORDER BY borrow_count DESC " +
                "LIMIT 10";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            int rank = 1;
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("author_name"),
                        rs.getInt("year_published"),
                        rs.getFloat("price"),
                        0,
                        rs.getString("barcode_image_url"),
                        rs.getString("description"));
                int borrowCount = rs.getInt("borrow_count");
                TopBorrowedBookInfo info = new TopBorrowedBookInfo(rank++, book, borrowCount);
                topList.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new TopBorrowedBookStatistic(periodTime, topList);
    }

    class ViewStatsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PeriodTime periodTime = selectPeriodFrm.getPeriodTime();
            viewStatistics(periodTime);
        }
    }

    class BackToHomeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new HomeController();
            selectPeriodFrm.dispose();
        }
    }

    class BookClickListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                JTable table = (JTable) e.getSource();
                int row = table.getSelectedRow();
                if (row != -1) {
                    int bookId = (int) table.getValueAt(row, 1);
                    readerListController.viewReaderListBorrowedBook(bookId);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
