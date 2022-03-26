package com.baosight.scaletransfer.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "list")
public class ScaleLogList {

	List<ScaleLog> scaleLogs;
	
	/**
	 * get the scaleLogs - 
	 * @return the scaleLogs
	 */
	@XmlElement
	public List<ScaleLog> getScaleLogs() {
		return scaleLogs;
	}
	
	/**
	 * set the scaleLogs - 
	 */
	public void setScaleLogs(List<ScaleLog> scaleLogs) {
		this.scaleLogs = scaleLogs;
	} /** 所有scale的集合*/
	
}
