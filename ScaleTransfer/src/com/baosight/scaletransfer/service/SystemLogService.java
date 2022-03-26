package com.baosight.scaletransfer.service;

import java.util.List;
import java.util.Map;
import com.baosight.scaletransfer.bean.ScaleLog;

public interface SystemLogService {
	
	/**
	 * 	传入startime, endTime, logGrade的map
	 * 	返回List<ScaleLog>
	 * @param map
	 * @return
	 */
	public List<ScaleLog> query(Map<String,String> map);
}
