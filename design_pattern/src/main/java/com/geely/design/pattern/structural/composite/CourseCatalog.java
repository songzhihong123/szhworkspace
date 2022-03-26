package com.geely.design.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhihong Song on 2020/12/10 17:42
 */

public class CourseCatalog extends CatalogComponent {

    private List<CatalogComponent> items = new ArrayList<>();
    private String name;
    private Integer level;

    public CourseCatalog(String name,Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void add(CatalogComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) {
        items.remove(catalogComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        items.forEach(bean ->{
            if(this.level != null){
                for (int i = 0 ; i < this.level ; i ++){
                    System.out.print("  ");
                }
            }
            bean.print();
        });
    }
}
