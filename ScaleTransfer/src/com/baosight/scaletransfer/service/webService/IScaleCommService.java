package com.baosight.scaletransfer.service.webService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IScaleCommService {
	/*
	 * 连接
	 * */
	public void connect();
	/*
	 * 发送数据
	 * */
	public void send(String info);
	/*
	 * 接受数据
	 * */
	public String recv();
	/*
	 * 断开连接
	 * */
	public void disConnect();
	/*
	 * 发送0级命令
	 * */
	public Map<String, String> sendCmd(String cmd);
	/*
	 * 发送1级命令
	 * */
	public Map<String, String> sendCmd(String cmd,String endIdentification);
	/*
	 * 获取请求方的IP地址
	 * */
	public String getIpAddr(HttpServletRequest request);

}
