package com.baosight.scaletransfer.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baosight.scaletransfer.bean.ScaleLog;
import com.baosight.scaletransfer.bean.ScaleLogList;
import com.baosight.scaletransfer.service.util.CommConstant;
import com.baosight.scaletransfer.service.util.ScaleXMLUtil;
import com.baosight.scaletransfer.service.SystemLogService;

public class SystemLogServiceImpl implements SystemLogService{
	private final String xmlPath = CommConstant.LogXmlPath;
	
	@Override
	public List<ScaleLog> query(Map<String,String> map) {
		String startTime = map.get("startTime");
		String endTime = map.get("endTime");
		String logGrade = map.get("logGrade");
        Object object = ScaleXMLUtil.xmlToBean(xmlPath,ScaleLogList.class);
        ScaleLogList scaleLogList = (ScaleLogList) object;
        List<ScaleLog> scaleLogs = scaleLogList.getScaleLogs();
        List<ScaleLog> result = new ArrayList<>();
        for(ScaleLog log : scaleLogs) {
        	if(startTime.compareTo(log.getRecCreatorTime()) <= 0 && endTime.compareTo(log.getRecCreatorTime()) >= 0 
        			&& logGrade.equals(log.getLogGrade())) {
        		result.add(log);
        	}
        }
		return result;
	}
}
