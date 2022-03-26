package com.geely.design.principle.compositionaggregation;

/**
 * 组合复用原则
 * 组合 聚合 关系
 */
public class Test {

    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.setDbConnection(new PostgreSQLConnection());
        productDao.addProduct();
    }

}
