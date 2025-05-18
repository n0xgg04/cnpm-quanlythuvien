package com.example.main.controller;

import com.example.main.views.HomeFrm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController {
    private HomeFrm homeFrm;

    public HomeController() {
        homeFrm = new HomeFrm();
        homeFrm.setVisible(true);

        homeFrm.addBorrowListener(new BorrowListener());
        homeFrm.addReturnListener(new ReturnListener());
        homeFrm.addBookStatisticListener(new BookStatisticListener());
        homeFrm.addReaderStatisticListener(new ReaderStatisticListener());
    }

    class BookStatisticListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new TopBorrowedBookStatisticController();
            homeFrm.dispose();
        }
    }

    class ReaderStatisticListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: Implement statistic logic
        }
    }

    class ReturnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: Implement return logic
        }
    }

    class BorrowListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: Implement borrow logic
        }
    }
}
