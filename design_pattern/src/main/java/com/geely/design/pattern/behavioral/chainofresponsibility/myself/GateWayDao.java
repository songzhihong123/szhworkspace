package com.geely.design.pattern.behavioral.chainofresponsibility.myself;

/**
 * @ClassName GatwDao
 * @Description TODO
 * @Author szh
 * @Date 2022年07月05日
 */
public interface GateWayDao {


    GatewayEntity getGatewayEntity(Integer handleId);


    GatewayEntity getFirstGatewayEntity();


}
