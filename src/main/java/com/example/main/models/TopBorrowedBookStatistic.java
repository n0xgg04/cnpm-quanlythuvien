package com.example.main.models;

import java.util.List;

public class TopBorrowedBookStatistic {
    private PeriodTime periodTime;

    private List<TopBorrowedBookInfo> topBorrowedBookInfos;

    public TopBorrowedBookStatistic() {
    }

    public TopBorrowedBookStatistic(PeriodTime periodTime, List<TopBorrowedBookInfo> topBorrowedBookInfos) {
        this.periodTime = periodTime;
        this.topBorrowedBookInfos = topBorrowedBookInfos;
    }

    public PeriodTime getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(PeriodTime periodTime) {
        this.periodTime = periodTime;
    }

    public List<TopBorrowedBookInfo> getTopBorrowedBookInfos() {
        return topBorrowedBookInfos;
    }

    public void setTopBorrowedBookInfos(List<TopBorrowedBookInfo> topBorrowedBookInfos) {
        this.topBorrowedBookInfos = topBorrowedBookInfos;
    }
}
