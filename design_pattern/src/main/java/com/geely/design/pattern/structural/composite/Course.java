package com.geely.design.pattern.structural.composite;

/**
 * Created by Zhihong Song on 2020/12/10 17:39
 */

public class Course extends CatalogComponent {

    private String name;
    private Double price;

    public Course(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public Double getPrice(CatalogComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println("Course Name: " + name + " Price: "+ price);
    }
}
