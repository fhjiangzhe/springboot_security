package com.example.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
* 绑定表字段信息
* @ClassName: UserBindEntity 
* @Description: TODO
* @author 史超
* @date 2015年12月31日 下午3:42:38
 */
@Entity
@Table(name ="fp_user_bind")
@DynamicInsert
public class UserBindEntity implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -3839273372690126464L;
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	public enum BindStatus{
		NOCOOPERATION("掌柜与掌门没有建立关系",-1),SELF("当前掌门人为本公司",-30),
		AUDITING("待合作",0),PASS("已合作",10),CLOSE("庄家关闭",11),DENY("拒绝",-10),UNBIND("解除绑定",-20);
		
		private String name;
		private Integer type;
		private BindStatus(String name, Integer type) {
    		this.name = name;
    		this.type = type;
    	}

    	public String getName() {
    		return this.name;
    	}

    	public Integer getType() {
    		return type;
    	}
		
	}
	public UserBindEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public UserBindEntity(Integer importOrgId, Integer bindOrgId) {
		super();
		this.importOrgId = importOrgId;
		this.bindOrgId = bindOrgId;
	}

	@Id
	@GeneratedValue
	private Integer id;
	/**
	 * 导入方公司orgId
	 */
	private Integer importOrgId;
	/**
	 * 导入方公司orgName
	 */
	private String importOrgName;
	/**
	 * 导出方公司orgid
	 */
	private Integer bindOrgId;
	/**
	 * 导出方公司名称 htg 2015年9月10日 YJHL201509A
	 */
	private String bindOrgName;
	/**
	 * 导出方公司域名
	 */
	private String domain;
	/**
	 * 绑定状态
	 */
	private Integer bindStatus;
	/**
	 * 名额生效状态
	 */
	private Integer effectStatus;
	/**
	 * 申请时间
	 */
	private Date applyTime;
	/**
	 * 申请人
	 */
	private String applyUserName;
	/**
	 * 申请人id
	 */
	private Integer applyUserId;
	/**
	 * 审核时间
	 */
	private Date auditTime;
	/**
	 * 审核人
	 */
	private String auditUserName;
	/**
	 * 审核人id
	 */
	private Integer auditUserId;
	/**
	 * 解绑时间
	 */
	private Date unbindTime;
	/**
	 * 解绑人
	 */
	private String unbindUserName;
	/**
	 * 解绑人id
	 */
	private Integer unbindUserId;
	/**
	 * 理由
	 */
	private String reason;
	
	/**
	 * 外部联系人
	 */
	@Transient
	private String contactName;
	
	/**
	 * 外部联系人电话
	 */
	@Transient
	private String contactMobile;
	/**
	 * 客服
	 */
	@Transient
	private String servicerName;
	//webIm的账号
	@Transient
	private String imId;
	//webIm的密码
	@Transient
	private String imPwd;
	//webIm的联系人姓名
	@Transient
	private String employeeName;
	//是否显示webIm图标
	@Transient
	private Boolean isShow;
	//老状态
	@Transient
	private Integer oldStatus;

	//申请来源,0代表网页端;1代表客户端
	@Transient
	private Integer applySource;
	@Transient
	private Integer importStatus;
	@Transient
	private String imOnLineStatus;

	@Transient
	public boolean isPoisonPill() { return false; }

	/**
	 * @return importStatus
	 */
	public Integer getImportStatus() {
		return importStatus;
	}
	/**
	 * @param importStatus 赋值为  importStatus
	 */
	public void setImportStatus(Integer importStatus) {
		this.importStatus = importStatus;
	}
	/**
	 * @return the applySource
	 */
	public Integer getApplySource() {
		return applySource;
	}
	/**
	 * @param applySource 要设置的applySource
	 */
	public void setApplySource(Integer applySource) {
		this.applySource = applySource;
	}
	/**
	 * @return oldStatus
	 */
	public Integer getOldStatus() {
		return oldStatus;
	}
	/**
	 * @param oldStatus 赋值为  oldStatus
	 */
	public void setOldStatus(Integer oldStatus) {
		this.oldStatus = oldStatus;
	}
	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id 赋值为  id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return importOrgId
	 */
	public Integer getImportOrgId() {
		return importOrgId;
	}
	/**
	 * @param importOrgId 赋值为  importOrgId
	 */
	public void setImportOrgId(Integer importOrgId) {
		this.importOrgId = importOrgId;
	}
	/**
	 * @return importOrgName
	 */
	public String getImportOrgName() {
		return importOrgName;
	}
	/**
	 * @param importOrgName 赋值为  importOrgName
	 */
	public void setImportOrgName(String importOrgName) {
		this.importOrgName = importOrgName;
	}
	/**
	 * @return bindOrgId
	 */
	public Integer getBindOrgId() {
		return bindOrgId;
	}
	/**
	 * @param bindOrgId 赋值为  bindOrgId
	 */
	public void setBindOrgId(Integer bindOrgId) {
		this.bindOrgId = bindOrgId;
	}
	/**
	 * @return bindOrgName
	 */
	public String getBindOrgName() {
		return bindOrgName;
	}
	/**
	 * @param bindOrgName 赋值为  bindOrgName
	 */
	public void setBindOrgName(String bindOrgName) {
		this.bindOrgName = bindOrgName;
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
	public Integer getBindStatus() {
		return bindStatus;
	}
	/**
	 * @param bindStatus 赋值为  bindStatus
	 */
	public void setBindStatus(Integer bindStatus) {
		this.bindStatus = bindStatus;
	}
	/**
	 * @return effect_status
	 */
	public Integer getEffectStatus() {
		return effectStatus;
	}
	/**
	 * @param effect_status 赋值为  effect_status
	 */
	public void setEffectStatus(Integer effectStatus) {
		this.effectStatus = effectStatus;
	}
	/**
	 * @return applyTime
	 */
	public Date getApplyTime() {
		return applyTime;
	}
	/**
	 * @param applyTime 赋值为  applyTime
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	/**
	 * @return applyUserId
	 */
	public Integer getApplyUserId() {
		return applyUserId;
	}
	/**
	 * @param applyUserId 赋值为  applyUserId
	 */
	public void setApplyUserId(Integer applyUserId) {
		this.applyUserId = applyUserId;
	}
	/**
	 * @return auditTime
	 */
	public Date getAuditTime() {
		return auditTime;
	}
	/**
	 * @param auditTime 赋值为  auditTime
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	/**
	 * @return auditUserName
	 */
	public String getAuditUserName() {
		return auditUserName;
	}
	/**
	 * @param auditUserName 赋值为  auditUserName
	 */
	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}
	/**
	 * @return auditUserId
	 */
	public Integer getAuditUserId() {
		return auditUserId;
	}
	/**
	 * @param auditUserId 赋值为  auditUserId
	 */
	public void setAuditUserId(Integer auditUserId) {
		this.auditUserId = auditUserId;
	}
	/**
	 * @return unbindTime
	 */
	public Date getUnbindTime() {
		return unbindTime;
	}
	/**
	 * @param unbindTime 赋值为  unbindTime
	 */
	public void setUnbindTime(Date unbindTime) {
		this.unbindTime = unbindTime;
	}
	/**
	 * @return unbindUserName
	 */
	public String getUnbindUserName() {
		return unbindUserName;
	}
	/**
	 * @param unbindUserName 赋值为  unbindUserName
	 */
	public void setUnbindUserName(String unbindUserName) {
		this.unbindUserName = unbindUserName;
	}
	/**
	 * @return unbindUserId
	 */
	public Integer getUnbindUserId() {
		return unbindUserId;
	}
	/**
	 * @param unbindUserId 赋值为  unbindUserId
	 */
	public void setUnbindUserId(Integer unbindUserId) {
		this.unbindUserId = unbindUserId;
	}
	/**
	 * @return reason
	 */
	public String getReason() {
		return reason;
	}
	/**
	 * @param reason 赋值为  reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**
	 * @return contactName
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * @param contactName 赋值为  contactName
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * @return contactMobile
	 */
	public String getContactMobile() {
		return contactMobile;
	}
	/**
	 * @param contactMobile 赋值为  contactMobile
	 */
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	/**
	 * @return servicerName
	 */
	public String getServicerName() {
		return servicerName;
	}
	/**
	 * @param servicerName 赋值为  servicerName
	 */
	public void setServicerName(String servicerName) {
		this.servicerName = servicerName;
	}
	/**
	 * @return imId
	 */
	public String getImId() {
		return imId;
	}
	/**
	 * @param imId 赋值为  imId
	 */
	public void setImId(String imId) {
		this.imId = imId;
	}
	/**
	 * @return imPwd
	 */
	public String getImPwd() {
		return imPwd;
	}
	/**
	 * @param imPwd 赋值为  imPwd
	 */
	public void setImPwd(String imPwd) {
		this.imPwd = imPwd;
	}
	/**
	 * @return employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName 赋值为  employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return isShow
	 */
	public Boolean getIsShow() {
		return isShow;
	}
	/**
	 * @param isShow 赋值为  isShow
	 */
	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}
	/**
	 * @return applyUserName
	 */
	public String getApplyUserName() {
		return applyUserName;
	}
	/**
	 * @param applyUserName 赋值为  applyUserName
	 */
	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}
	public String getImOnLineStatus() {
		return imOnLineStatus;
	}
	public void setImOnLineStatus(String imOnLineStatus) {
		this.imOnLineStatus = imOnLineStatus;
	}
	
	
}
