package com.geely.design.principle.compositionaggregation;

public class PostgreSQLConnection extends DBConnection {

    @Override
    public String getConnection() {
            return "PostgreSQL的数据连接";
    }
}
