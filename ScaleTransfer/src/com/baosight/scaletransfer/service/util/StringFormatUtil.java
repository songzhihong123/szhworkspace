package com.baosight.scaletransfer.service.util;

import java.util.HashMap;
import java.util.Map;

public class StringFormatUtil {
	/*获取重量的格式化字符串*/
	/*去皮格式化字符串*/
	//SS重量值单位
	public static Map<String, String> getWeighValueAndTareFormat(String target){
		Map<String ,String> map = new HashMap<>();
		String[] split = target.split(" ");
		if(split[split.length-1].length() <= 2) {
			map.put("Weight", split[split.length-2]);
			map.put("Uom", split[split.length-1]);
//			return split[split.length-2]+split[split.length-1];
		}else {
			map.put("Weight", "");
			map.put("Uom", split[split.length-1]);
		}
		return map;
	}
	/*秤的序列号格式化字符串*/
	//I4A"文本"
	public static String getDeviceSeqNoFormat(String target){
		String[] split = target.split(" ");
		return split[split.length-1];	
	}
	/*获取秤信息格式化字符串*/
	//|I6 IB P|I6 MAX 60.00 kg|I6 MIN 0.40 kg|I6 TH 60.00 kg|I6 R0 0.02 kg/60.00 kg|I6 E 0d
	public static Map<String, String> getScaleInfoFormat(String target){
		String[] split = target.split("\\|");
		Map<String, String> map = new HashMap<>();
		map.put("量程单位", split[2].split(" ")[split[2].split(" ").length-1]);
		map.put("最大量程", split[2].split(" ")[split[2].split(" ").length-2]+
							split[2].split(" ")[split[2].split(" ").length-1]);
		map.put("最小量程", split[3].split(" ")[split[3].split(" ").length-2]+
					split[3].split(" ")[split[3].split(" ").length-1]);
		
		return map;
		
	}
	/*获取秤型号格式化字符串*/
	//I11 A "ICS429a-BB30/c
	public static String getScaleModelFormat(String target){
		String[] split = target.split(" ");
		String[] split2 = split[split.length-1].split("\"");
		return split2[split2.length-1];
		
	}
	
	
}
