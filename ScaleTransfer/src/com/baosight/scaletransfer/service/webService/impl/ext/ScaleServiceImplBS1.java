package com.baosight.scaletransfer.service.webService.impl.ext;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

import com.baosight.scaletransfer.service.util.CommScaleCmdConstant;
import com.baosight.scaletransfer.service.webService.IScaleCommService;
import com.baosight.scaletransfer.service.webService.ScaleService;
import com.baosight.scaletransfer.service.webService.impl.CommServiceConstructor;
import com.baosight.scaletransfer.service.webService.impl.ScaleServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScaleServiceImplBS1 extends ScaleServiceImpl{
	
	private IScaleCommService scaleCommService;
	
	public ScaleServiceImplBS1(){}
	
	public ScaleServiceImplBS1(String scaleId){
		scaleCommService = CommServiceConstructor.getIScaleCommService(scaleId);
		
	}
	
	public static void main(String[] args) {
		ScaleServiceImplBS1 s = new ScaleServiceImplBS1("testScale5");
		s.setClear("testScale5");
	}
	
	
	
	@Override
	public String getWeighValue(String scaleId) {
		
		
		scaleCommService.connect();
		String recv = scaleCommService.recv();
		System.out.println(recv);
				
		return recv;
	}
	

	@Override
	public String scaleIsOnline(String scaleId) {
		String scaleStatus = null;
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String callback = request.getParameter("callback");
		
		
		
		Map<String, String> map1 = scaleCommService.sendCmd("S");
		
		String scaleSocket = map1.get("result");
		if(StringUtils.isEmpty(scaleSocket)){
			scaleStatus = "秤处于离线状态";
		}else{
			scaleStatus = "秤在线";
		}
		return scaleStatus;
	}
	
	//"TARE" 去皮
	@Override
	public String setTare(String scaleId, String tareValue, String uom) {
		
		scaleCommService.connect();
		scaleCommService.sendCmd("TARE");
		
				
		return null;
	}
	
	//"CLR" 清零
	@Override
	public String setClear(String scaleId) {
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = null;
		String callback = null;
		if(message != null){
			 request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
			 callback = request.getParameter("callback");
		}
		scaleCommService.connect();
		Map<String, String> map1 = scaleCommService.sendCmd("CLR");
		String clearZero = map1.get("result");
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> map = new HashMap<>();
		//{"IsSuccess":true,"ResultDesc":"Z A\r\n"}
		if(clearZero == ""){
			map.put("IsSuccess", "true");
			map.put("ResultDesc", map1.get("desc"));
		}else{
			map.put("IsSuccess", "true");
			map.put("ResultDesc", clearZero);
		}
		
		String str = null;
		try {
			str = objectMapper.writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(message != null){
			if(callback == null) {
				String s = str;
				super.setLog("清零",s,request,scaleId);
				return s;
			}else{
				String s = callback + "("+str+")";
				super.setLog("清零",s,request,scaleId);
				return s;
			}
		}else{
			return str;
		}
	}

	@Override
	public String getDeviceSeqNo(String scaleId) {
		
		return null;
	}

	@Override
	public String getScaleInfo(String scaleId) {
		
		return null;
	}

	@Override
	public String showMethods(String scaleId) {
		return "{methods:"+"\n"+"getWeighValue"+"\n"+"scaleIsOnline"+"\n"+
				"setTare"+"\n"+"setClear"+"\n"+"getDeviceSeqNo"+"\n"+"getScaleInfo"+"}";
	}

}
