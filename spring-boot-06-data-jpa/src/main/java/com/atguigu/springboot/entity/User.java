package com.atguigu.springboot.entity;

import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity//告诉jpa这是一个实体类（和数据库表映射的类）
@Table(name = "tbl_user")//@Table指定和哪个数据库表对应；如果省略默认表名就是类名小写
public class User {
    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "last_name",length = 50)//这是和数据表对应的一个列
    private String lastName;
    @Column //省略默认列名就是属性名
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
