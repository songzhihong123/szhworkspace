package com.geely.design.pattern.structural.flyweight;

/**
 * Created by Zhihong Song on 2020/11/25 18:27
 */

public class Manager implements Employee {

    @Override
    public void report() {
        System.out.println(reportContent);
    }

    private String department;
    private String reportContent;

    public Manager(String department) {
        this.department = department;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }
}
