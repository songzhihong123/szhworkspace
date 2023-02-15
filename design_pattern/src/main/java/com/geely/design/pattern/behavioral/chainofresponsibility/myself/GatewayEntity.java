package com.geely.design.pattern.behavioral.chainofresponsibility.myself;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName GatewayEntity
 * @Description TODO
 * @Author szh
 * @Date 2022年07月05日
 */
@Data
@AllArgsConstructor
public class GatewayEntity {


    private Integer handleId;

    private String name;

    private String conference;

    private Integer preHandleId;

    private Integer nextHandleId;



}
