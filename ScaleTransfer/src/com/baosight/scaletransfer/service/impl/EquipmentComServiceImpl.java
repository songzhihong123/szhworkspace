package com.baosight.scaletransfer.service.impl;

import java.util.List;
import com.baosight.scaletransfer.bean.Scale;
import com.baosight.scaletransfer.bean.ScaleList;
import com.baosight.scaletransfer.service.EquipmentComService;
import com.baosight.scaletransfer.service.util.CommConstant;
import com.baosight.scaletransfer.service.util.ScaleXMLUtil;

public class EquipmentComServiceImpl implements EquipmentComService{
	private String xmlPath = CommConstant.xmlPath; /* scale数据地址*/
	
	@Override
	public List<Scale> loadEquiment() {
		Object object = ScaleXMLUtil.xmlToBean(xmlPath, ScaleList.class);
		ScaleList scaleList = (ScaleList) object;
		return scaleList.getScales();
	}
}
