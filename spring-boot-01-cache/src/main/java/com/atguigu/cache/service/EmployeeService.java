package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "emp"/*,cacheManager = "employeeCacheManager"*/) // 可以抽取缓存的公共配置
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果缓存起来，以后相同的数据从缓存中获取
     *
     * CacheManager管理多个Cache组件，对缓存真正的CRUD操作在Cache组件中，每一个缓存组件都有自己唯一的一个名字。
     *
     * 原理：
     *     1、自动配置类；
     *     2、缓存的配置类
     *          org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.GuavaCacheConfiguration
     *          org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration【默认】
     *          org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
     *       3、哪个配置类生效  SimpleCacheConfiguration
     *
     *       4、 给容器中注册了一个Cachemanager:ConcurrentHashMapCacheManager
     *       5、可以获取和创建ConcurrentMapCache类型的缓存组件；他的作用是将组件保存在ConcurrentMap中。
     *
     *
     *      运行流程：
     *          @Cacheable
     *          1、方法运行之前先去查询Cache(缓存组件)，按照cacheNames指定的名字去获取；
     *              （CacheManager先获取相应的缓存），第一次获取缓存如果没有Cache组件就会自动创建
     *          2、去Cache中获取缓存的内容，使用的key，默认就是方法的参数
     *              key 是按照某种生成策略生成的，默认是使用keyGenerator生成的，默认是使用SimpleKeyGenerator生成的key
     *                  SimpleKeyGenerator生成key的默认策略是：
     *                      如果没有参数： key = new SimpleKey();
     *                      如果有一个参数：key = 参数的值；
     *                      如果有多个参数：key = new SimpleKey(params);
     *           3、没有查到缓存就去调用目标方法。
     *           4、将目标方法返回的结果，放进缓存中。
     *      @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认是按照参数的值作为key去查询缓存，
     *      如果没有就运行目标方法然后将结果放入缓存，以后再来调用就直接直接用缓存中的数据
     *
     *      核心：
     *          1、使用CancheManager[ConcurrentHashMapCacheManager]按照名字得到Cache[ConcurrentMapCache]组件
     *          2、key使用keyGenerator生成，默认是SimpleKeyGenerator
     *
     *
     *      几个属性：
     *            cacheNames/value：指定缓存的名字;将方法的返回直接过放在哪个缓存中，是数组的方式，可以指定多个缓存
     *            key：缓存数据时的key，默认是使用方法参数的值
     *               编写SpEL表达式: #id:参数id值  #a0 #p0 #root.args[0]
     *            keyGenerator：key的生成器：可以指定key的生成器的组件id
     *                key/keyGenerator 二选一使用
     *            cacheManager：指定缓存管理器；或者可以指定cacheResolver 缓存解析器
     *            condition：指定符合条件的情况下才缓存  condition="#id > 0"
     *                       condition = "#a0 > 1": 第一个参数大于1的时候才进行缓存
     *            unless: unless指定的条件为true，方法的返回值就不会缓存；
     *                可以获取到结果进行判断   unless = "#result == null "
     *                unless = "#a0 == 2" : 如果第一个参数的值是2，结果不缓存
     *            sync：缓存是否使用异步模式
     *                  启用异步模式，unless属性就不支持了
     *
     * @param id
     * @return
     */
    @Cacheable(/*value = {"emp"}*//*,keyGenerator = "myKeyGenerator" ,condition = "#a0 > 1 ",unless = "#a0 == 2"*/)
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee empById = employeeMapper.getEmpById(id);
        return empById;
    }

    /**
     * @CachePut: 即调用方法又更新缓存数据：同步更新缓存
     * 修改了数据库某个数据，同时也有更新缓存
     *
     * 运行时机：
     *     1、先调用目标方法
     *     2、然后将目标方法的结果缓存起来
     * 测试步骤：
     *     1、查询一号员工，查到的结果会放在缓存中
     *              key：1  value: zhangsan  zhangsan@qq.com
     *     2、以后查询还是之前的结果
     *     3、更新1号员工【lastName=zhangsan,gender=0】
     *     4、查询一号员工？
     *             应该是更新后的员工:
     *                  key = "#employee.id"
     *                  key = "#result.id"
     *                  @Cacheable 的 key 是不能用#result的
     *             为什么是没更新前的？  【1号员工没有在缓存中更新】
     */
    @CachePut(/*cacheNames = {"emp"},*/key = "#result.id")
    public Employee update(Employee employee){
        System.out.println("updateEmp"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * @CacheEvict:缓存清除
     *      key：指定要清楚的数据
     *      allEntries = true: 清楚指定缓存中的所有数据
     *      beforeInvocation = false ； 缓存的清楚是否在防止执行之前执行
     *          默认代表是在方法执行之后执行
     *
     */
    @CacheEvict(/*cacheNames = {"emp"},*//*key = "#id",*/allEntries = true)
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp:"+id);
        //employeeMapper.deleteEmpById(id);
        int i = 10 / 0;
    }

    //@Caching 定义复杂的缓存规则
    @Caching(
            cacheable = {
                    @Cacheable(/*value = "emp",*/key = "#lastName")
            },
            put = {
                    @CachePut(/*value = "emp" ,*/key = "#result.id"),
                    @CachePut(/*value = "emp" ,*/key = "#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName){
        Employee emp = employeeMapper.getEmpByLastName(lastName);
        return emp;
    }


}
