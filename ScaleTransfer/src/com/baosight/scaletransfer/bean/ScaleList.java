package com.baosight.scaletransfer.bean;
/**
 *  xml scale映射类
 * @author tianwei
 * @date 2019年1月4日
 * @version 1.0
 */
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "list")
public class ScaleList {
	
	List<Scale> scales; /** 所有scale的集合*/
	
	/**
	 * get the scales - 
	 * @return the scales
	 */
	@XmlElement
	public List<Scale> getScales() {
		return scales;
	}
	
	/**
	 * set the scales - 
	 */
	public void setScales(List<Scale> scales) {
		this.scales = scales;
	}
	
}
