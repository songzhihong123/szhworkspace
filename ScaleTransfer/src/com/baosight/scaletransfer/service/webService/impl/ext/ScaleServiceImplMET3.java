package com.baosight.scaletransfer.service.webService.impl.ext;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;



import com.baosight.scaletransfer.service.util.StringFormatUtil;
import com.baosight.scaletransfer.service.webService.IScaleCommService;
import com.baosight.scaletransfer.service.webService.impl.ScaleServiceImpl;
import com.baosight.scaletransfer.service.webService.impl.CommServiceConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScaleServiceImplMET3 extends ScaleServiceImpl{
	
	private IScaleCommService scaleCommService;
		
	public ScaleServiceImplMET3(String scaleId){
		scaleCommService = CommServiceConstructor.getIScaleCommService(scaleId);
		
	}
	
	public String getWeighValue(String scaleId) {
		return "秤不支持该功能";
	}

	@Override
	public String setTare(String scaleId, String tareValue, String uom) {
		return "秤不支持该功能";
	}

	@Override
	public String setClear(String scaleId) {
		return "秤不支持该功能";
	}
	
	@Override
	public String scaleIsOnline(String scaleId) {
		String scaleStatus = null;
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String callback = request.getParameter("callback");
		
		/*Socket socket = ScaleSocketUtil.getSocket(scaleId, new File(xmlPath));
		Map<String, String> map1 = ScaleSocketUtil.scaleSocket(socket, "S");*/
		
		scaleCommService.connect();
		Map<String, String> map1 = scaleCommService.sendCmd("S");	
		
		String scaleSocket = map1.get("result");
		if(StringUtils.isEmpty(scaleSocket)){
			scaleStatus = "秤处于离线状态";
		}else{
			scaleStatus = "秤在线";
		}
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> map = new HashMap<>();
		////{"IsSuccess":true,"ResultDesc":"Z A\r\n"}
		
		map.put("IsSuccess", "true");
		map.put("scaleStatus", scaleStatus);
		map.put("ResultDesc", scaleSocket);
		String str = null;
		try {
			str = objectMapper.writeValueAsString(map);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(callback == null) {
			String s = str;
			super.setLog("检测秤是否在线",s,request,scaleId);
			return s;
		}else{
			String s = callback + "("+str+")";
			super.setLog("检测秤是否在线",s,request,scaleId);
			return s;
		}
		
	}

	@Override
	public String getDeviceSeqNo(String scaleId) {
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String callback = request.getParameter("callback");
		
		/*Socket socket = ScaleSocketUtil.getSocket(scaleId, new File(xmlPath));
		Map<String, String> map1 = ScaleSocketUtil.scaleSocket(socket, "I4");*/
		
		scaleCommService.connect();
		Map<String, String> map1 = scaleCommService.sendCmd("I4");
		
		String deviceSeqNoBak = map1.get("result");		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> map = new HashMap<>();		
		if(deviceSeqNoBak == ""){
			map.put("IsSuccess", "true");
			map.put("deviceSeqNo", "null");
			map.put("ResultDesc", map1.get("desc"));
		}else{
			String deviceSeqNo = StringFormatUtil.getDeviceSeqNoFormat(deviceSeqNoBak);
			map.put("IsSuccess", "true");
			map.put("deviceSeqNo", deviceSeqNo);
			map.put("ResultDesc", deviceSeqNoBak);
		}
				
		String str = null;
		try {
			str = objectMapper.writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(callback == null) {
			String s = str;
			super.setLog("获取序列号",s,request,scaleId);
			return s;
		}else{
			String s = callback + "("+str+")";
			super.setLog("获取序列号",s,request,scaleId);
			return s;
		}
	}

	@Override
	public String getScaleInfo(String scaleId) {
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String callback = request.getParameter("callback");
		
		/*Socket socket = ScaleSocketUtil.getSocket(scaleId, new File(xmlPath));
		Map<String, String> map1 = ScaleSocketUtil.scaleSocket(socket, "I6","IE");
		Map<String, String> map2 = ScaleSocketUtil.scaleSocket(socket, "I11");//秤的型号
*/		
		scaleCommService.connect();
		Map<String, String> map1 = scaleCommService.sendCmd("I6","IE");
		Map<String, String> map2 = scaleCommService.sendCmd("I11");
		String scaleInfoBak = map1.get("result");
		String scaleModel = map2.get("result");
		Map<String, String> map = StringFormatUtil.getScaleInfoFormat(scaleInfoBak);
		String scaleModel1 = StringFormatUtil.getScaleModelFormat(scaleModel);
		
		
		map.put("IsSuccess", "true");
		map.put("设备型号", scaleModel1);
		map.put("ResultDesc", scaleInfoBak);
		ObjectMapper objectMapper = new ObjectMapper();
		String str = null;
		try {
			str = objectMapper.writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(callback == null) {
			String s = str;
			super.setLog("获取秤信息",s,request,scaleId);
			return s;
		}else{
			String s = callback + "("+str+")";
			super.setLog("获取秤信息",s,request,scaleId);
			return s;
		}
	}
	

	@Override
	public String showMethods(String scaleId) {		
		return "{methods:"+"\n"+"getDeviceSeqNo"+"\n"+"getScaleInfo"+"\n"+"scaleIsOnline"+"}";
	}
}
