package com.geely.design.pattern.structural.proxy.db;

/**
 * Created by Zhihong Song on 2020/12/22 17:03
 */

public class DataSourceContextHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDBType(String dbType){
        CONTEXT_HOLDER.set(dbType);
    }

    public static String getDBType(){
        String dbType = CONTEXT_HOLDER.get();
        return dbType;
    }

    public static void clearDBType(){
        CONTEXT_HOLDER.remove();
    }


}
