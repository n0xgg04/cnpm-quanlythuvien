package com.example.main.views;

import com.example.main.models.PeriodTime;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

public class SelectPeriodFrm extends JFrame {
    private JXDatePicker startDatePicker;
    private JXDatePicker endDatePicker;
    private JButton viewStatsButton;
    private JButton homeButton;

    public SelectPeriodFrm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(500, 250));
        setLayout(new BorderLayout());

        // Hàng đầu tiên: chỉ có nút về trang chủ bên trái
        JPanel topPanel = new JPanel(new BorderLayout());
        homeButton = new JButton("Về trang chủ");
        topPanel.add(homeButton, BorderLayout.WEST);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        add(topPanel, BorderLayout.NORTH);

        // Nội dung chính ở giữa
        JPanel contentPanel = new JPanel(new MigLayout("fillx, insets 20", "[center]", "[]20[]20[]"));

        JLabel titleLabel = new JLabel("Hãy chọn khoảng thời gian muốn xem thống kê");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(titleLabel, "growx, wrap");

        startDatePicker = new JXDatePicker();
        startDatePicker.setDate(new Date());
        startDatePicker.setFormats("dd/MM/yyyy");

        endDatePicker = new JXDatePicker();
        endDatePicker.setDate(new Date());
        endDatePicker.setFormats("dd/MM/yyyy");

        JLabel startDateLabel = new JLabel("Ngày bắt đầu:");
        JLabel endDateLabel = new JLabel("Ngày kết thúc:");

        JPanel datePanel = new JPanel(new MigLayout("insets 0", "[]10[]"));
        datePanel.add(startDateLabel);
        datePanel.add(startDatePicker);
        datePanel.add(endDateLabel);
        datePanel.add(endDatePicker);
        contentPanel.add(datePanel, "wrap");

        viewStatsButton = new JButton("Xem thống kê");
        contentPanel.add(viewStatsButton, "center");

        add(contentPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public PeriodTime getPeriodTime() {
        Date startDate = startDatePicker.getDate();
        Date endDate = endDatePicker.getDate();
        return new PeriodTime(startDate, endDate);
    }

    public void showDialog(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    public void addViewStatsListener(ActionListener log) {
        viewStatsButton.addActionListener(log);
    }

    public void addHomeListener(ActionListener l) {
        homeButton.addActionListener(l);
    }
}
