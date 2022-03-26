package com.geely.design.pattern.structural.facade;

/**
 * Created by Zhihong Song on 2020/11/12 19:51
 */

public class QualifyService {

        public boolean isAvailable(PointsGift gift){
            System.out.println("校验 "+gift.getName() + " 积分资格通过，库存通过！");
            return true;
        }


    }
