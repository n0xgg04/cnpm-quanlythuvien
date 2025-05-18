package com.example.main.views;

import com.example.main.models.TopBorrowedBookStatistic;
import com.example.main.utils.BarcodeUtils;
import com.example.main.models.TopBorrowedBookInfo;
import com.example.main.models.PeriodTime;
import com.example.main.models.Book;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class TopBorrowedBookStatisticFrm extends JFrame {
    private JLabel titleLabel;
    private JLabel dateRangeLabel;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton backButton;
    private JLabel lblNoData;
    private JScrollPane scrollPane;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private TopBorrowedBookStatistic currentStatistic;

    public TopBorrowedBookStatisticFrm() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 500));
        setLayout(new BorderLayout());

        // Top panel với nút Quay lại
        JPanel topPanel = new JPanel(new BorderLayout());
        backButton = new JButton("Quay lại");
        topPanel.add(backButton, BorderLayout.WEST);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        add(topPanel, BorderLayout.NORTH);

        // CardLayout cho phần nội dung
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Panel chứa bảng
        JPanel tablePanel = new JPanel(new MigLayout("fill, insets 20", "[grow,fill]", "[]10[]20[]push"));
        titleLabel = new JLabel("Thống kê top sách mượn nhiều");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tablePanel.add(titleLabel, "growx, wrap");

        dateRangeLabel = new JLabel();
        dateRangeLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        dateRangeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        tablePanel.add(dateRangeLabel, "align right, wrap");

        String[] columnNames = { "Thứ tự", "Mã", "Tên sách", "Tác giả", "Mã vạch", "Số lượt mượn" };
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 4)
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
        tablePanel.add(scrollPane, "span, grow, push, wrap");

        JPanel noDataPanel = new JPanel(new GridBagLayout());
        lblNoData = new JLabel("Không có dữ liệu thống kê", SwingConstants.CENTER);
        lblNoData.setFont(new Font("Dialog", Font.PLAIN, 20));
        noDataPanel.add(lblNoData, new GridBagConstraints());

        cardPanel.add(tablePanel, "table");
        cardPanel.add(noDataPanel, "nodata");
        add(cardPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    public void setStatisticData(TopBorrowedBookStatistic statistic) {
        this.currentStatistic = statistic;
        dateRangeLabel.setText(formatDateRange(statistic.getPeriodTime()));
        if (statistic == null || statistic.getTopBorrowedBookInfos() == null
                || statistic.getTopBorrowedBookInfos().isEmpty()) {
            cardLayout.show(cardPanel, "nodata");
        } else {
            cardLayout.show(cardPanel, "table");
            updateTableData(statistic);
        }
    }

    private String formatDateRange(PeriodTime periodTime) {
        if (periodTime == null || periodTime.getStartDate() == null || periodTime.getEndDate() == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Từ ngày %s tới %s", sdf.format(periodTime.getStartDate()),
                sdf.format(periodTime.getEndDate()));
    }

    private void updateTableData(TopBorrowedBookStatistic statistic) {
        tableModel.setRowCount(0);
        if (statistic == null || statistic.getTopBorrowedBookInfos() == null)
            return;
        int stt = 1;
        for (TopBorrowedBookInfo info : statistic.getTopBorrowedBookInfos()) {
            Book book = info.getBook();
            Object[] row = new Object[] {
                    stt++,
                    book.getId(),
                    book.getName(),
                    book.getAuthorName(),
                    BarcodeUtils.createBarcodeIcon(book.getBarcodeImageUrl()),
                    info.getBorrowingCount()
            };
            tableModel.addRow(row);
        }
    }

    public JTable getTable() {
        return table;
    }

    public void addBackListener(ActionListener l) {
        backButton.addActionListener(l);
    }

    public void addBookClickListener(MouseListener l) {
        table.addMouseListener(l);
    }
}