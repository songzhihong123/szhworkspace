package com.geely.design.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhihong Song on 2020/11/25 18:29
 */

public class EmployeeFactory {

    private final static Map<String ,Employee> EMPLOYE_EMAP = new HashMap<>();

    public static Employee getManager(String department){
        Manager manager = (Manager)EMPLOYE_EMAP.get(department);
        if(null == manager){
            manager = new Manager(department);
            System.out.print("创建部门经理：" + department);
            String reportContent = department+"部门汇报，报告的内容是.........";
            manager.setReportContent(reportContent);
            System.out.print("创建报告：" + reportContent);
            EMPLOYE_EMAP.put(department,manager);

        }
        return manager;
    }



}
