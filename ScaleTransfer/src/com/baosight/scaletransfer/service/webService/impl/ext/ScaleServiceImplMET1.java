package com.baosight.scaletransfer.service.webService.impl.ext;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

import com.baosight.scaletransfer.service.util.CommScaleCmdConstant;
import com.baosight.scaletransfer.service.util.StringFormatUtil;
import com.baosight.scaletransfer.service.webService.IScaleCommService;
import com.baosight.scaletransfer.service.webService.impl.ScaleServiceImpl;
import com.baosight.scaletransfer.service.webService.impl.CommServiceConstructor;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScaleServiceImplMET1 extends ScaleServiceImpl{
	
	private IScaleCommService scaleCommService;
	
	
	public ScaleServiceImplMET1(String scaleId){
		scaleCommService = CommServiceConstructor.getIScaleCommService(scaleId);
		
	}
	
	
	@Override
	public String getWeighValue(String scaleId) {
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = null;
		String callback = null;
		if(message != null){
			 request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
			 callback = request.getParameter("callback");
		}
		
		
		
		scaleCommService.connect();
		Map<String, String> map1 = scaleCommService.sendCmd(CommScaleCmdConstant.SOCKET_S);	
		
		
		String weighValueBak = map1.get("result");
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> map = new HashMap<>();
		if(weighValueBak == ""){
			map.put("Uom", "null");
			map.put("Weight", "null");
			map.put("IsSuccess", "true");
			map.put("ResultDesc", map1.get("desc"));
		}else{
			Map<String,String> info = StringFormatUtil.getWeighValueAndTareFormat(weighValueBak);
			//{"Uom":"kg","Weight":"4.04","IsSuccess":true,"ResultDesc":"T S       4.04 kg\r\n"}
			map.put("Uom", info.get("Uom"));
			map.put("Weight", info.get("Weight"));
			map.put("IsSuccess", "true");
			map.put("ResultDesc", weighValueBak);
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
				super.setLog("获取称重重量",s,request,scaleId);
				return s;
			}else{
				String s = callback + "("+str+")";
				super.setLog("获取称重重量",s,request,scaleId);
				return s;
			}
		}else{
			return str;
		}
		
	}

	@Override
	public String scaleIsOnline(String scaleId) {
		String scaleStatus = null;
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = null;
		String callback = null;
		if(message != null){
			request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
			callback = request.getParameter("callback");
		}
		
		
		scaleCommService.connect();
		Map<String, String> map1 = scaleCommService.sendCmd(CommScaleCmdConstant.SOCKET_S);	
		
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
			e.printStackTrace();
		}
		if(message != null){
			if(callback == null) {
				String s = str;
				super.setLog("检测秤是否在线",s,request,scaleId);
				return s;
			}else{
				String s = callback + "("+str+")";
				super.setLog("检测秤是否在线",s,request,scaleId);
				return s;
			}
		}else{
			return str;
		}
		
	}

	@Override
	public String setTare(String scaleId, String tareValue, String uom) {
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = null;
		String callback = null;
		if(message != null){
			request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
			callback = request.getParameter("callback");
		}
		
		
		scaleCommService.connect();
		Map<String, String> map1 = scaleCommService.sendCmd(CommScaleCmdConstant.SOCKET_T);//去皮
		Map<String, String> map2 = null;
		if(tareValue != null){
			map2 = scaleCommService.sendCmd("TA "+tareValue+" "+uom);//设置皮重
		}
		String tareBak = map1.get("result");		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> map = new HashMap<>();
		if(tareValue != null){
			if(tareBak == ""){
				map.put("Uom", "null");
				map.put("Weight", "null");
				map.put("IsSuccess", "true");
				map.put("ResultDesc", map1.get("desc")+map2.get("desc"));
			}else{
				Map<String,String> info = StringFormatUtil.getWeighValueAndTareFormat(tareBak);
				//{"Uom":"kg","Weight":"4.04","IsSuccess":true,"ResultDesc":"T S       4.04 kg\r\n"}
				map.put("Uom", info.get("Uom"));
				map.put("tare", info.get("Weight"));
				map.put("IsSuccess", "true");
				map.put("ResultDesc", tareBak);
			}		
		}else{
			if(tareBak == ""){
				map.put("Uom", "null");
				map.put("Weight", "null");
				map.put("IsSuccess", "true");
				map.put("ResultDesc", map1.get("desc"));
			}else{
				Map<String,String> info = StringFormatUtil.getWeighValueAndTareFormat(tareBak);
				//{"Uom":"kg","Weight":"4.04","IsSuccess":true,"ResultDesc":"T S       4.04 kg\r\n"}
				map.put("Uom", info.get("Uom"));
				map.put("tare", info.get("Weight"));
				map.put("IsSuccess", "true");
				map.put("ResultDesc", tareBak);
			}		
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
				super.setLog("去皮",s,request,scaleId);
				return s;
			}else{
				String s = callback + "("+str+")";
				super.setLog("去皮",s,request,scaleId);
				return s;
			}
		}else{
			return str;
		}
		
	}

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
		Map<String, String> map1 = scaleCommService.sendCmd(CommScaleCmdConstant.SOCKET_Z);
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
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = null;
		String callback = null;
		if(message != null){
			request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
			callback = request.getParameter("callback");
		}
		
		
		scaleCommService.connect();
		Map<String, String> map1 = scaleCommService.sendCmd(CommScaleCmdConstant.SOCKET_I4);
		
		String deviceSeqNoBak = map1.get("result");		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> map = new HashMap<>();		
		if(deviceSeqNoBak == ""){
//			{"IsSuccess":"true","deviceSeqNo":"\"0000000\"","ResultDesc":"I4 A \"0000000\""}
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
		if(message != null){
			if(callback == null) {
				String s = str;
				super.setLog("获取序列号",s,request,scaleId);
				return s;
			}else{
				String s = callback + "("+str+")";
				super.setLog("获取序列号",s,request,scaleId);
				return s;
			}
		}else{
			return str;
		}
		
	}

	@Override
	public String getScaleInfo(String scaleId) {
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = null;
		String callback = null;
		if(message != null){
			request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
			callback = request.getParameter("callback");
		}
		
		scaleCommService.connect();
		Map<String, String> map1 = scaleCommService.sendCmd(CommScaleCmdConstant.SOCKET_I6,CommScaleCmdConstant.SOCKET_IE);
		Map<String, String> map2 = scaleCommService.sendCmd(CommScaleCmdConstant.SOCKET_I11);
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
		if(message != null){
			if(callback == null) {
				String s = str;
				super.setLog("获取秤信息",s,request,scaleId);
				return s;
			}else{
				/*{"最大量程":"6.0000kg","IsSuccess":"true","最小量程":"0.0050kg","量程单位":"kg","设备型号":"ICS685",
					"ResultDesc":"|I6 IB P|I6 MAX 6.0000 kg|I6 MIN 0.0050 kg|I6 TH 6.0000 kg|I6 R0 0.0001 kg/6.0000 kg|I6 E 0d"}*/
				String s = callback + "("+str+")";
				super.setLog("获取秤信息",s,request,scaleId);
				return s;
			}
		}else{
			return str;
		}
		
	}
	
	

	@Override
	public String showMethods(String scaleId) {		
		return "{methods:"+"\n"+"getWeighValue"+"\n"+"scaleIsOnline"+"\n"+
		"setTare"+"\n"+"setClear"+"\n"+"getDeviceSeqNo"+"\n"+"getScaleInfo"+"}";
	}
}
