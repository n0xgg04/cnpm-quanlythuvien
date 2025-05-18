package com.example.main.views;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;

public class HomeFrm extends JFrame {
    private JButton btnBorrow, btnReturn, btnStatistic;
    private JMenuItem itemBookStatistic, itemReaderStatistic;
    private JPopupMenu statisticMenu;
    private JLabel welcomeLabel;

    public HomeFrm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        welcomeLabel = new JLabel("Quản lý thư viện", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Dialog", Font.BOLD, 22));
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(40, 120, 40, 120));

        btnBorrow = new JButton("Tạo lượt mượn sách");
        btnReturn = new JButton("Tạo lượt trả sách");
        btnStatistic = new JButton("Thống kê");

        btnBorrow.setFont(new Font("Dialog", Font.PLAIN, 18));
        btnReturn.setFont(new Font("Dialog", Font.PLAIN, 18));
        btnStatistic.setFont(new Font("Dialog", Font.PLAIN, 18));

        buttonPanel.add(btnBorrow);
        buttonPanel.add(btnReturn);
        buttonPanel.add(btnStatistic);

        add(buttonPanel, BorderLayout.CENTER);

        statisticMenu = new JPopupMenu();
        itemBookStatistic = new JMenuItem("Thống kê sách mượn nhiều");
        itemReaderStatistic = new JMenuItem("Thống kê bạn đọc mượn nhiều");
        statisticMenu.add(itemBookStatistic);
        statisticMenu.add(itemReaderStatistic);

        itemBookStatistic.setForeground(Color.BLACK);
        itemReaderStatistic.setForeground(Color.BLACK);
        itemBookStatistic.setFont(new Font("Dialog", Font.PLAIN, 16));
        itemReaderStatistic.setFont(new Font("Dialog", Font.PLAIN, 16));
        itemBookStatistic.putClientProperty("JMenuItem.selectedForeground", Color.BLACK);
        itemReaderStatistic.putClientProperty("JMenuItem.selectedForeground", Color.BLACK);

        UIManager.put("MenuItem.selectionBackground", new Color(30, 144, 255));
        UIManager.put("MenuItem.selectionForeground", Color.BLACK);
        UIManager.put("MenuItem.background", Color.WHITE);
        UIManager.put("MenuItem.foreground", Color.BLACK);
        SwingUtilities.updateComponentTreeUI(statisticMenu);

        btnStatistic.addActionListener(e -> {
            statisticMenu.show(btnStatistic, btnStatistic.getWidth() / 2, btnStatistic.getHeight());
        });
    }

    public void addBorrowListener(ActionListener l) {
        btnBorrow.addActionListener(l);
    }

    public void addReturnListener(ActionListener l) {
        btnReturn.addActionListener(l);
    }

    public void addBookStatisticListener(ActionListener l) {
        itemBookStatistic.addActionListener(l);
    }

    public void addReaderStatisticListener(ActionListener l) {
        itemReaderStatistic.addActionListener(l);
    }
}
