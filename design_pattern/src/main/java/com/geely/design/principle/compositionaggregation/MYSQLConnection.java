package com.geely.design.principle.compositionaggregation;

public class MYSQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "MYSQL的数据连接";
    }
}
