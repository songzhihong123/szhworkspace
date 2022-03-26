package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        //thymeleaf默认拼串
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //来到添加页面,查出所有的部门
        return "emp/add";
    }

    //员工添加
    //spring mvc 自动会将请求参数和入参对象进行一一绑定，
    //要求请求参数的名字和javaBean入参的对象里面的属性姓名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println(employee);
        //保存员工
        employeeDao.save(employee);
        //redirect 表示重定向
        //forwrda 请求转发
        //  / 代表当前项目路径
        return "redirect:/emps";
    }

    //来到修改页面，先查出来当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable(value = "id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //页面显示所有的页面列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //来到修改页面,修改添加二合一
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("========"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String delEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
