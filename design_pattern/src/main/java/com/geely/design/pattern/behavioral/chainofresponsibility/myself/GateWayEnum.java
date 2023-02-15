package com.geely.design.pattern.behavioral.chainofresponsibility.myself;

import lombok.Getter;

/**
 * @ClassName GateWayEnum
 * @Description TODO
 * @Author szh
 * @Date 2022年07月05日
 */
@Getter
public enum GateWayEnum {

    API_HANDLER(new GatewayEntity(1, "api接口限流", "cn.dgut.design.chain_of_responsibility.GateWay.impl.ApiLimitGatewayHandler", null, 2)),
    BLACKLIST_HANDLER(new GatewayEntity(2, "黑名单拦截", "cn.dgut.design.chain_of_responsibility.GateWay.impl.BlacklistGatewayHandler", 1, 3)),
    SESSION_HANDLER(new GatewayEntity(3, "用户会话拦截", "cn.dgut.design.chain_of_responsibility.GateWay.impl.SessionGatewayHandler", 2, null)),
    ;

    private GatewayEntity gatewayEntity;

    GateWayEnum(GatewayEntity gatewayEntity){
        this.gatewayEntity = gatewayEntity;
    }


}
