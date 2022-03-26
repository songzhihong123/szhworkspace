package com.baosight.scaletransfer.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;
import com.baosight.scaletransfer.bean.Scale;
import com.baosight.scaletransfer.bean.ScaleList;
import com.baosight.scaletransfer.service.ParameterConfigureService;
import com.baosight.scaletransfer.service.util.CommConstant;
import com.baosight.scaletransfer.service.util.ScaleXMLUtil;

public class ParameterConfigureServiceImpl implements ParameterConfigureService{
	private String xmlPath = CommConstant.xmlPath; /* scale数据地址*/
	
	@Override
	public List<Scale> loadEquiment() {
		Object object = ScaleXMLUtil.xmlToBean(xmlPath, ScaleList.class);
		ScaleList scaleList = (ScaleList) object;
		return scaleList.getScales();
	}

	@Override
	public String deleteEquiment(List<String> deviceIds) {
		return ScaleXMLUtil.deleteElements(new File(xmlPath), deviceIds);
	}

	@Override
	public String updateEquimentInfo(Map<String, String> equimentInfoMap) {
		return ScaleXMLUtil.updateScaleInfo(equimentInfoMap, new File(xmlPath));
	}

	@Override
	public Map<String, String> loadConfig() {
		return ScaleXMLUtil.loadConfig(new File(xmlPath));
	}

	@Override
	public String updateConfig(Map<String, String> configMap) {
		return ScaleXMLUtil.updateScaleInfo(configMap, new File(xmlPath));
	}

	@Override
	public String addConfig(Map<String, String> configMap) {
		// TODO 自动生成的方法存根
		return ScaleXMLUtil.insertConfig(configMap,new File(xmlPath));
	}

}
