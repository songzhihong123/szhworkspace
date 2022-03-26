package com.baosight.scaletransfer.service.webService.impl;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;


/**
 * JAXRSServerFactoryBean是用来发布REST服务的
 * */
public class TMain {

	public static void main(String[] args) {
		JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();  
        //设置服务发布的地址  
		//factoryBean.getInInterceptors().add(new JsonpPreStreamInterceptor());
		//factoryBean.getInInterceptors().add(new MyJsonp());
		//factoryBean.getInInterceptors().add(new LJQ());
		//factoryBean.getInInterceptors().add(new MethodToInvokeInterceptor());
		//factoryBean.getOutInterceptors().add(new LJQ());
        factoryBean.setAddress("http://localhost:8739/WcfWeighService");
        //设置实现类对象  
        factoryBean.setServiceBean(new ScaleServiceImpl());  
        //发布服务  
        factoryBean.create();   
        
//        Endpoint.publish("http://localhost:8088/hello", new ScaleServiceImpl());
	}
	
}
