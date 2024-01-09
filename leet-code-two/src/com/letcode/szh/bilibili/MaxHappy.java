package com.letcode.szh.bilibili;

import java.util.List;

/**
 * @ClassName MaxHappy
 * @Description MaxHappy
 * @Author szh
 * @Date 2024年01月08日
 */
public class MaxHappy {

    /*

        这个公司要办party ， 你可以绝顶那些员工来，哪些员工不来。但是要遵循如下规则：
        1、如果某个员工来了，那么这个员工的饿所有直接下级都不能来
        2、排队的整体快乐值是所有到场员工快乐值的累加
        3、你的目标是让派对的整体快乐值尽量大

        给定一颗多叉树的头节点boss，请返回派对的最大快乐值

     */

    public static class Employee{
        public int happy; // 员工的快乐值

        public List<Employee> nexts; // 员工的直接下级
    }

    public static int maxHappy(Employee employee){

        Info info = process(employee);

        return Math.max(info.laiMaxHappy , info.buMaxHappy);
    }


    public static class Info{
        public int laiMaxHappy;
        public int buMaxHappy;
        public Info(int laiMaxHappy , int buMaxHappy){
            this.laiMaxHappy = laiMaxHappy;
            this.buMaxHappy = buMaxHappy;
        }

    }

    public static Info process(Employee employee){
        if(employee.nexts == null || employee.nexts.size() == 0){
            return new Info(employee.happy , 0);
        }

        int lai = employee.happy; // 员工来的时候的快乐值
        int bu = 0; // 员工不来的时候的快乐值

        for(Employee next : employee.nexts){
            Info nextInfo = process(next);
            lai += nextInfo.buMaxHappy;
            bu += Math.max(nextInfo.buMaxHappy , nextInfo.laiMaxHappy);

        }
        return new Info(lai , bu);
    }








}
