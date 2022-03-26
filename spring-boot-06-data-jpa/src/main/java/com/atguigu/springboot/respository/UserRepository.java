package com.atguigu.springboot.respository;

import com.atguigu.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository完成数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {
}
