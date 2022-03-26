package com.baosight.scaletransfer.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
/**
 * 	称量设备基本属性表
 * @author tianwei
 * @date 2018年12月19日
 * @version 1.0
 */
public class Scale implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String recId = " ";		/* 记录ID*/ 
	private Long recLineNo = new Long(0);		/* 记录行序号*/
	private String recCreator = " ";		/* 记录创建者*/
	private String recCreatorTime = " ";		/* 记录创建时刻*/
	private String recRevisor = " ";		/* 记录修改者*/
	private String recReviseTime = " ";		/* 记录修改时刻*/
	private String recDeleteor = " ";		/* 记录删除者*/
	private String recDeleteTime = " ";		/* 记录删除时刻*/
	private String recStatus = " ";		/* 记录状态*/
	private String deleteFlag = " ";		/* 删除标记*/
	private String archiveFlag = " ";		/* 归档标记*/
	private String orgUnitCode = " ";		/* 组织单位代码*/
	private String companyCode = " ";		/* 公司代码(套账)*/
	private String recWstId = " ";		/* 记录工作站ID*/
	private String remark = " ";		/* 备注*/
	private String deviceId = " ";		/* 设备ID*/
	private String deviceCname = " ";		/* 设备中文名称*/
	private String deviceSeqNo = " ";		/* 设备序列号*/
	private String processingClass = " ";		/* 处理类*/
	
	/**
	 * get the recId - 记录ID
	 * @return the recId
	 */
	@XmlAttribute(name = "recId")
	public String getRecId() {
		return recId;
	}
	
	/**
	 * set the recId - 记录ID
	 */
	public void setRecId(String recId) {
		this.recId = recId;
	}
	
	/**
	 * get the recLineNo - 记录行序号
	 * @return the recLineNo
	 */
	@XmlAttribute(name = "recLineNo")
	public Long getRecLineNo() {
		return recLineNo;
	}
	
	/**
	 * set the recLineNo - 记录行序号
	 */
	public void setRecLineNo(Long recLineNo) {
		this.recLineNo = recLineNo;
	}
	
	/**
	 * get the recCreator - 记录创建者
	 * @return the recCreator
	 */
	@XmlAttribute(name = "recCreator")
	public String getRecCreator() {
		return recCreator;
	}
	
	/**
	 * set the recCreator - 记录创建者
	 */
	public void setRecCreator(String recCreator) {
		this.recCreator = recCreator;
	}
	
	/**
	 * get the recCreatorTime - 记录创建时刻
	 * @return the recCreatorTime
	 */
	@XmlAttribute(name = "recCreatorTime")
	public String getRecCreatorTime() {
		return recCreatorTime;
	}
	
	/**
	 * set the recCreatorTime - 记录创建时刻
	 */
	public void setRecCreatorTime(String recCreatorTime) {
		this.recCreatorTime = recCreatorTime;
	}
	
	/**
	 * get the recRevisor - 记录修改者
	 * @return the recRevisor
	 */
	@XmlAttribute(name = "recRevisor")
	public String getRecRevisor() {
		return recRevisor;
	}
	
	/**
	 * set the recRevisor - 记录修改者
	 */
	public void setRecRevisor(String recRevisor) {
		this.recRevisor = recRevisor;
	}
	
	/**
	 * get the recReviseTime - 记录修改时刻
	 * @return the recReviseTime
	 */
	@XmlAttribute(name = "recReviseTime")
	public String getRecReviseTime() {
		return recReviseTime;
	}
	
	/**
	 * set the recReviseTime - 记录修改时刻
	 */
	public void setRecReviseTime(String recReviseTime) {
		this.recReviseTime = recReviseTime;
	}
	
	/**
	 * get the recDeleteor - 记录删除者
	 * @return the recDeleteor
	 */
	@XmlAttribute(name = "recDeleteor")
	public String getRecDeleteor() {
		return recDeleteor;
	}
	
	/**
	 * set the recDeleteor - 记录删除者
	 */
	public void setRecDeleteor(String recDeleteor) {
		this.recDeleteor = recDeleteor;
	}
	
	/**
	 * get the recDeleteTime - 记录删除时刻
	 * @return the recDeleteTime
	 */
	@XmlAttribute(name = "recDeleteTime")
	public String getRecDeleteTime() {
		return recDeleteTime;
	}
	
	/**
	 * set the recDeleteTime - 记录删除时刻
	 */
	public void setRecDeleteTime(String recDeleteTime) {
		this.recDeleteTime = recDeleteTime;
	}
	
	/**
	 * get the recStatus - 记录状态
	 * @return the recStatus
	 */
	@XmlAttribute(name = "recStatus")
	public String getRecStatus() {
		return recStatus;
	}
	
	/**
	 * set the recStatus - 记录状态
	 */
	public void setRecStatus(String recStatus) {
		this.recStatus = recStatus;
	}
	
	/**
	 * get the deleteFlag - 删除标记
	 * @return the deleteFlag
	 */
	@XmlAttribute(name = "deleteFlag")
	public String getDeleteFlag() {
		return deleteFlag;
	}
	
	/**
	 * set the deleteFlag - 删除标记
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	/**
	 * get the archiveFlag - 归档标记
	 * @return the archiveFlag
	 */
	@XmlAttribute(name = "archiveFlag")
	public String getArchiveFlag() {
		return archiveFlag;
	}
	
	/**
	 * set the archiveFlag - 归档标记
	 */
	public void setArchiveFlag(String archiveFlag) {
		this.archiveFlag = archiveFlag;
	}
	
	/**
	 * get the orgUnitCode - 组织单位代码
	 * @return the orgUnitCode
	 */
	@XmlAttribute(name = "orgUnitCode")
	public String getOrgUnitCode() {
		return orgUnitCode;
	}
	
	/**
	 * set the orgUnitCode - 组织单位代码
	 */
	public void setOrgUnitCode(String orgUnitCode) {
		this.orgUnitCode = orgUnitCode;
	}
	
	/**
	 * get the companyCode - 公司代码(套账)
	 * @return the companyCode
	 */
	@XmlAttribute(name = "companyCode")
	public String getCompanyCode() {
		return companyCode;
	}
	
	/**
	 * set the companyCode - 公司代码(套账)
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	/**
	 * get the recWstId - 记录工作站ID
	 * @return the recWstId
	 */
	@XmlAttribute(name = "recWstId")
	public String getRecWstId() {
		return recWstId;
	}
	
	/**
	 * set the recWstId - 记录工作站ID
	 */
	public void setRecWstId(String recWstId) {
		this.recWstId = recWstId;
	}
	
	/**
	 * get the remark - 备注
	 * @return the remark
	 */
	@XmlAttribute(name = "remark")
	public String getRemark() {
		return remark;
	}
	
	/**
	 * set the remark - 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * get the deviceId - 设备ID
	 * @return the deviceId
	 */
	@XmlAttribute(name = "deviceId")
	public String getDeviceId() {
		return deviceId;
	}
	
	/**
	 * set the deviceId - 设备ID
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	/**
	 * get the deviceCname - 设备中文名称
	 * @return the deviceCname
	 */
	@XmlAttribute(name = "deviceCname")
	public String getDeviceCname() {
		return deviceCname;
	}
	
	/**
	 * set the deviceCname - 设备中文名称
	 */
	public void setDeviceCname(String deviceCname) {
		this.deviceCname = deviceCname;
	}
	
	/**
	 * get the deviceSeqNo - 设备序列号
	 * @return the deviceSeqNo
	 */
	@XmlAttribute(name = "deviceSeqNo")
	public String getDeviceSeqNo() {
		return deviceSeqNo;
	}
	
	/**
	 * set the deviceSeqNo - 设备序列号
	 */
	public void setDeviceSeqNo(String deviceSeqNo) {
		this.deviceSeqNo = deviceSeqNo;
	}
	
	/**
	 * get the processingClass - 处理类
	 * @return the processingClass
	 */
	@XmlAttribute(name = "processingClass")
	public String getProcessingClass() {
		return processingClass;
	}
	
	/**
	 * set the processingClass - 处理类
	 */
	public void setProcessingClass(String processingClass) {
		this.processingClass = processingClass;
	}
	
}
