package com.auguigu.security.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登录功能
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userlogin");
        //1、 /login来到登录页 ， 如果没哟登录就会来到登录页面
        //2、重定向到/login?error表示登录失败
        //3、更多详细
        //4、默认post形式的/login代表处理登录
        //5、一旦定制Loginpage；那么LoginPage的post请求就是登录

        //开启自动配置的注销功能
        http.logout().logoutSuccessUrl("/"); // 注销成功以后来到首页
        //1、访问/logout 表示用户注销 情况session
        //2、注销成功会返回 /login?logout  页面

        //开启记住我功能
        http.rememberMe().rememberMeParameter("remeber");
        //登录成功将cookie发给浏览器保存，以后登录带上这个cookie，只要通过检查就可以免登陆
        //点击注销也会删除cookie

    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("zhangsan").password("123456").roles("VIP1","VIP2")
                .and().withUser("lisi").password("123456").roles("VIP2","VIP3")
                .and().withUser("wangwu").password("123456").roles("VIP1","VIP3");
    }


}
