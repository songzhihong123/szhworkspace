package com.baosight.scaletransfer.service.webService.impl;

import java.io.File;
import java.util.Map;

import com.baosight.scaletransfer.service.util.CommConstant;
import com.baosight.scaletransfer.service.util.ScaleXMLUtil;
import com.baosight.scaletransfer.service.webService.IScaleCommService;
import com.baosight.scaletransfer.service.webService.mode.ScaleRs232ServiceImpl;
import com.baosight.scaletransfer.service.webService.mode.ScaleSocketServiceImpl;

public class CommServiceConstructor {
	
	public static String xmlPath = CommConstant.xmlPath;
	public static IScaleCommService scaleCommService;
	
	public static IScaleCommService getIScaleCommService(String scaleId){
		//读取配置信息中的通信方式
		Map<String, String> scaleInfo = ScaleXMLUtil.getScaleInfo(scaleId, new File(xmlPath));
		String commServiceType=scaleInfo.get("remark");
		//依据对应的通信方式创建通信类
		if(commServiceType.equals("socket")){
			scaleCommService=new ScaleSocketServiceImpl(scaleId, new File(xmlPath));
			}else if (commServiceType.equals("Rs232")){
				scaleCommService=new ScaleRs232ServiceImpl(scaleId, new File(xmlPath));
					
			}
		return scaleCommService;	
	}
	
}
