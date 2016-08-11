/**
 * 
 */
package com.example.domain.mongo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

/** 
 * @ClassName: ImpdataMyMastersMain 
 * @Description: TODO
 * @author 史超
 * @date 2016年6月25日 下午3:01:12 
 */
@Document(collection = "impdata_master")
public class ImpdataMyMastersMain implements Serializable {

	@Id
	private String id;

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -4643515568638818312L;
	private Long orgId; // 庄家id
	private String orgName;//企业名称
	private String domain;//企业域名
	private int bindStatus;//绑定状态
	private int importStatus;//导入状态
	private int effectStatus;//占位状态
	/**是否是掌门人  1：是  0：不是*/
	private Boolean head_status;
	
	private Long bindId;//绑定id
	// 区域
    private String areaName;
	// 主营，经营VO对象
	private Map<String,OrgCertBusinessMasters> areaMap;
	
	//企业互联 港口 运价数
	private EnquiryOrgInfo enquiryOrgInfo;
	
	private HashSet<String> areaSet;
	private HashSet<String> carrierSet;
	private HashSet<String> routeSet;
	
	private int chargeConfigType;  //按船公司或按航线
	
	//排序字段
	private int isOrgPaid;  //公司是否付费
	private int isInMajor;  //搜索条件是否是在主营范围
	private double paidAmount;  //付费金额
	private Date paidDate;    //付费时间
	private int sortNum=999999;     //支撑后台排序字段
	
	/**
	 * @return orgId
	 */
	public Long getOrgId() {
		return orgId;
	}
	/**
	 * @param orgId 赋值为  orgId
	 */
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	/**
	 * @return orgName
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * @param orgName 赋值为  orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * @return domain
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @param domain 赋值为  domain
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * @return bindStatus
	 */
	public int getBindStatus() {
		return bindStatus;
	}
	/**
	 * @param bindStatus 赋值为  bindStatus
	 */
	public void setBindStatus(int bindStatus) {
		this.bindStatus = bindStatus;
	}
	/**
	 * @return head_status
	 */
	public Boolean getHead_status() {
		return head_status;
	}
	/**
	 * @param head_status 赋值为  head_status
	 */
	public void setHead_status(Boolean head_status) {
		this.head_status = head_status;
	}

	/**
	 * @return enquiryOrgInfo
	 */
	public EnquiryOrgInfo getEnquiryOrgInfo() {
		return enquiryOrgInfo;
	}
	/**
	 * @param enquiryOrgInfo 赋值为  enquiryOrgInfo
	 */
	public void setEnquiryOrgInfo(EnquiryOrgInfo enquiryOrgInfo) {
		this.enquiryOrgInfo = enquiryOrgInfo;
	}
	/**
	 * @return areaSet
	 */
	public HashSet<String> getAreaSet() {
		return areaSet;
	}
	/**
	 * @param areaSet 赋值为  areaSet
	 */
	public void setAreaSet(HashSet<String> areaSet) {
		this.areaSet = areaSet;
	}
	/**
	 * @return carrierSet
	 */
	public HashSet<String> getCarrierSet() {
		return carrierSet;
	}
	/**
	 * @param carrierSet 赋值为  carrierSet
	 */
	public void setCarrierSet(HashSet<String> carrierSet) {
		this.carrierSet = carrierSet;
	}
	/**
	 * @return routeSet
	 */
	public HashSet<String> getRouteSet() {
		return routeSet;
	}
	/**
	 * @param routeSet 赋值为  routeSet
	 */
	public void setRouteSet(HashSet<String> routeSet) {
		this.routeSet = routeSet;
	}
	/**
	 * @return areaName
	 */
	public String getAreaName() {
		return areaName;
	}
	/**
	 * @param areaName 赋值为  areaName
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	/**
	 * @return areaMap
	 */
	public Map<String, OrgCertBusinessMasters> getAreaMap() {
		return areaMap;
	}
	/**
	 * @param areaMap 赋值为  areaMap
	 */
	public void setAreaMap(Map<String, OrgCertBusinessMasters> areaMap) {
		this.areaMap = areaMap;
	}
	/**
	 * @return importStatus
	 */
	public int getImportStatus() {
		return importStatus;
	}
	/**
	 * @param importStatus 赋值为  importStatus
	 */
	public void setImportStatus(int importStatus) {
		this.importStatus = importStatus;
	}
	/**
	 * @return effectStatus
	 */
	public int getEffectStatus() {
		return effectStatus;
	}
	/**
	 * @param effectStatus 赋值为  effectStatus
	 */
	public void setEffectStatus(int effectStatus) {
		this.effectStatus = effectStatus;
	}
	public Long getBindId() {
		return bindId;
	}
	public void setBindId(Long bindId) {
		this.bindId = bindId;
	}
	public int getIsOrgPaid() {
		return isOrgPaid;
	}
	public void setIsOrgPaid(int isOrgPaid) {
		this.isOrgPaid = isOrgPaid;
	}
	public int getIsInMajor() {
		return isInMajor;
	}
	public void setIsInMajor(int isInMajor) {
		this.isInMajor = isInMajor;
	}
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
	}
	public int getSortNum() {
		return sortNum;
	}
	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}
	public int getChargeConfigType() {
		return chargeConfigType;
	}
	public void setChargeConfigType(int chargeConfigType) {
		this.chargeConfigType = chargeConfigType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}


