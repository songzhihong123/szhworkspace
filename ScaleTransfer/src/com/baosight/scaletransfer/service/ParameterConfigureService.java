package com.baosight.scaletransfer.service;

import java.util.List;
import java.util.Map;
import com.baosight.scaletransfer.bean.Scale;
public interface ParameterConfigureService {
	
	/**
	 * 	 加载所有设备数据
	 * @return List<Scale>
	 */
	public List<Scale> loadEquiment();
	
	/**
	 *	 删除所选所有设备数据
	 * @return 执行结果info
	 * @param 所要删除设备的deviceId
	 * @return
	 */
	public String deleteEquiment(List<String> deviceIds);
	
	/**
	 * 	更新所选设备的数据(单选）
	 * @param equimentInfoMap
	 * @return
	 */
	public String updateEquimentInfo(Map<String, String> equimentInfoMap);
	
	
	/**
	 * 	加载xml中所有配置数据
	 * @return
	 */
	public Map<String, String> loadConfig();
	
	/**
	 * 	更新配置数据
	 * @param configMap
	 * @return
	 */
	public String updateConfig(Map<String, String> configMap);
	
	/**
	 * 	增加配置数据
	 * @param configMap
	 * @return
	 */
	public String addConfig(Map<String, String> configMap);
	
		
}
