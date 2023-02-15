package com.geely.design.pattern.behavioral.chainofresponsibility.myself;

import lombok.val;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @ClassName GateDaoImpl
 * @Description TODO
 * @Author szh
 * @Date 2022年07月05日
 */
public class GateWayDaoImpl implements GateWayDao{


    private static Map<Integer , GatewayEntity> entityHashMap = new HashMap<>();

    static {
        GateWayEnum[] values =  GateWayEnum.values();
        for(GateWayEnum value : values){
            GatewayEntity entity = value.getGatewayEntity();
            entityHashMap.put(entity.getHandleId() , entity);
        }
    }


    @Override
    public GatewayEntity getGatewayEntity(Integer handleId) {
        return entityHashMap.get(handleId);
    }

    @Override
    public GatewayEntity getFirstGatewayEntity() {
        val collect = entityHashMap.values().stream()
                .filter(tar -> Objects.isNull(tar.getPreHandleId()))
                .collect(Collectors.toList());
        if(collect.isEmpty()){
            return null;
        }
        return collect.get(0);
    }
}
