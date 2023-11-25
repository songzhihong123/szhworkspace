package com.letcode.szh;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName Main
 * @Description TODO
 * @Author szh
 * @Date 2023年11月23日
 */
public class Main {


    public static void main(String[] args) {
        BigDecimal change = new BigDecimal("120").setScale(0, RoundingMode.HALF_UP);
        BigDecimal res = change;
        BigDecimal remainder = change.remainder(BigDecimal.TEN);
        if(remainder.compareTo(BigDecimal.ZERO) > 0){
            res = change.add(BigDecimal.TEN.subtract(remainder));
        }
        System.out.println(res.toPlainString());
    }


}
