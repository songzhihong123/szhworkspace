package com.letcode.szh.bilibili.middle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @ClassName ChooseWork
 * @Description ChooseWork
 * @Author szh
 * @Date 2024年01月14日
 */
public class ChooseWork {


    /*
       为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是
       在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。在牛牛选定了自己的
       工作之后，牛牛的伙伴来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴。

       public static class Job{
        private int money;
        private int hard;
        public Job(int money , int hard){
            this.money = money;
            this.hard = hard;
        }
    }

    给定一个Job类型的数组jobarr , 表示所有的工作。给定一饿int类型的数组arr，
    表示所有小伙伴的能力。返回int类型的数组，表示每一个小伙伴按照牛牛的标准选工作
    后所能获得的报酬。

     */

    public static class Job{
        private int money;
        private int hard;
        public Job(int money , int hard){
            this.money = money;
            this.hard = hard;
        }
    }


    public static class JobComparator implements Comparator<Job>{
        @Override
        public int compare(Job o1, Job o2) {
            return o1.hard != o2.hard ? (o1.hard - o2.hard) : (o2.money - o1.money);
        }
    }

    public static int[] getMoney(Job[] job , int[] ability){
        // 排序， 按照难度倒序， 难度一样，按照钱数升序
        Arrays.sort(job , new JobComparator());
        // key 为难度，value为钱数
        // 同一个key保留钱数最多的项
        TreeMap<Integer , Integer> map = new TreeMap<>();
        map.put(job[0].hard , job[0].money);
        Job pre = job[0];
        for(int i = 1 ; i < job.length ; i++){
            if(job[i].hard != pre.hard || (job[i].hard == pre.hard && job[i].money > pre.money)){
                pre = job[i];
                map.put(pre.hard , pre.money);
            }
        }

        int[] res = new int[ability.length];
        for(int i = 0 ; i < ability.length ; i++){
            Integer key = map.floorKey(ability[i]);
            res[i] = key != null ? map.get(key) : 0;
        }

        return res;
    }




}
