package com.baosight.scaletransfer.service;

import java.util.List;

import com.baosight.scaletransfer.bean.Scale;

public interface EquipmentComService {
	
	/**
	 * 	 加载所有设备数据
	 * @return List<Scale>
	 */
	public List<Scale> loadEquiment();
}
