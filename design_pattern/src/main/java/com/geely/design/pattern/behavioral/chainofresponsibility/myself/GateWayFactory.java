package com.geely.design.pattern.behavioral.chainofresponsibility.myself;

import lombok.val;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName GateWayFactory
 * @Description TODO
 * @Author szh
 * @Date 2022年07月05日
 */
public class GateWayFactory {

    private final static GateWayDao gateWayDao = new GateWayDaoImpl();


    public static GatewayHandler getFirstGatewayEntity(){

        GatewayEntity firstGatewayEntity = gateWayDao.getFirstGatewayEntity();
        GatewayHandler firstGatewayHandler = getInstance(firstGatewayEntity);
        if (firstGatewayHandler == null) {
            return null;
        }

        GatewayEntity tempGatewayEntity = firstGatewayEntity;
        Integer nextHandleid = null;
        GatewayHandler tempHandler = firstGatewayHandler;

        while((nextHandleid = tempGatewayEntity.getNextHandleId()) != null){
            GatewayEntity gatewayEntity = gateWayDao.getGatewayEntity(nextHandleid);
            GatewayHandler gatewayHandler = getInstance(gatewayEntity);
            tempHandler.setNextHandler(gatewayHandler);
            tempHandler = gatewayHandler;
            tempGatewayEntity = gatewayEntity;
        }
        return firstGatewayHandler;
    }



    private static GatewayHandler getInstance(GatewayEntity gatewayEntity){
        String conference = gatewayEntity.getConference();
        if(StringUtils.isBlank(conference)){
            return null;
        }
        try {
            Class<?> aClass = Class.forName(conference);
            return (GatewayHandler)aClass.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }



}
