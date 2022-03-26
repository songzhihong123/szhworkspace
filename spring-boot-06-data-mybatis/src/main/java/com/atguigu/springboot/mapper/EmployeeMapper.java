package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Employee;

//@Mapper 或者@MapperScan 扫描到装配的容器中
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);



}
