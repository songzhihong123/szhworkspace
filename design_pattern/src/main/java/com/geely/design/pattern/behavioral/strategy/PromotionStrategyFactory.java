package com.geely.design.pattern.behavioral.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhihong Song on 2020/12/24 21:19
 */

public class PromotionStrategyFactory {

    private static Map<String,PromotionStrategy> PROMOTION_STRATEGY_MAP = new HashMap<>();

    // 如果不想在代码块里面初始化Map的时候可以使用享元模式，
    //        Manager manager = (Manager)EMPLOYE_EMAP.get(department);
    //        if(null == manager){
    //            manager = new Manager(department);
    //            System.out.print("创建部门经理：" + department);
    //            String reportContent = department+"部门汇报，报告的内容是.........";
    //            manager.setReportContent(reportContent);
    //            System.out.print("创建报告：" + reportContent);
    //            EMPLOYE_EMAP.put(department,manager);
    //
    //        }
    static {
        PROMOTION_STRATEGY_MAP.put(PromotionKey.LIJIAN,new LijianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.FANXIAN,new FanxianPromotionStrategy());
        PROMOTION_STRATEGY_MAP.put(PromotionKey.MANJIAN,new ManjianPromotionStrategy());
    }

    private static final  PromotionStrategy NO_PROMOTION = new EmptyPromotionStrategy();

    private PromotionStrategyFactory(){

    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey){
        PromotionStrategy promotionStrategy = PROMOTION_STRATEGY_MAP.get(promotionKey);
        return promotionStrategy == null ? NO_PROMOTION : promotionStrategy;

    }

    private interface PromotionKey{
        String LIJIAN = "LIJIAN";
        String FANXIAN = "FANXIAN";
        String MANJIAN = "MANJIAN";
    }


}
