package com.example.main.views;

import com.example.main.models.ReaderBorrowedBookHistory;
import com.example.main.models.ReaderBorrowedBook;
import com.example.main.models.BorrowForm;
import com.example.main.models.Readership;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class ReaderListBorrowedBookFrm extends JFrame {
    private JLabel titleLabel;
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JButton backButton;

    public ReaderListBorrowedBookFrm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(900, 400));
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new BorderLayout());
        backButton = new JButton("Quay lại");
        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        add(topPanel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new MigLayout("fill, insets 20", "[grow,fill]", "[]20[]push"));

        titleLabel = new JLabel("Danh sách bạn đọc mượn sách");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(titleLabel, "growx, wrap");

        String[] columnNames = { "ID phiếu mượn", "Tên độc giả", "Mã vạch của độc giả", "Số lượng", "Ngày mượn",
                "Đã trả" };
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 2)
                    return ImageIcon.class;
                return super.getColumnClass(column);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setRowHeight(60);
        scrollPane = new JScrollPane(table);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Dialog", Font.BOLD, 16));
        contentPanel.add(scrollPane, "span, grow, push, wrap");

        add(contentPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public void setData(ReaderBorrowedBookHistory history) {
        tableModel.setRowCount(0);
        if (history == null || history.getReaderBorrowedBookTransaction() == null)
            return;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm\nd/M/yyyy");
        for (ReaderBorrowedBook rbb : history.getReaderBorrowedBookTransaction()) {
            BorrowForm borrowForm = rbb.getBorrowForm();
            Readership reader = rbb.getReaderShip();
            int borrowId = borrowForm != null ? borrowForm.getId() : 0;
            String readerName = reader != null ? reader.getFullname() : "";
            String barcodeUrl = reader != null ? reader.getBarcodeImageUrl() : "";
            ImageIcon barcodeIcon = createBarcodeIcon(barcodeUrl);
            int amount = rbb.getAmount();
            String borrowAtStr = borrowForm != null && borrowForm.getBorrowAt() != null
                    ? sdf.format(borrowForm.getBorrowAt())
                    : "";
            String returned = rbb.isReturned() ? "X" : "";
            tableModel.addRow(new Object[] { borrowId, readerName, barcodeIcon, amount, borrowAtStr, returned });
        }
    }

    private ImageIcon createBarcodeIcon(String barcodeImageUrl) {
        try {
            if (barcodeImageUrl != null && !barcodeImageUrl.isEmpty()) {
                java.net.URL url = new java.net.URL(barcodeImageUrl);
                java.awt.image.BufferedImage img = javax.imageio.ImageIO.read(url);
                if (img != null) {
                    return new ImageIcon(img.getScaledInstance(120, 50, Image.SCALE_SMOOTH));
                }
            }
        } catch (Exception e) {
        }
        java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(120, 50,
                java.awt.image.BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics2D g2 = img.createGraphics();
        g2.setColor(java.awt.Color.LIGHT_GRAY);
        g2.fillRect(0, 0, 120, 50);
        g2.setColor(java.awt.Color.BLACK);
        g2.drawString("Barcode", 30, 25);
        g2.dispose();
        return new ImageIcon(img);
    }

    public void addBackListener(ActionListener l) {
        backButton.addActionListener(l);
    }
}
