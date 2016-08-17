package com.example.domain.elasticsearch;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
* 绑定表字段信息
* @ClassName: UserBindElsEntity
* @Description: TODO
* @author 史超
* @date 2015年12月31日 下午3:42:38
 */
@Document(indexName = "impdata",type = "fp_user_bind")
public class UserBindElsEntity implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -3839273372690126464L;

	@Id
	private Integer id;
	/**
	 * 导入方公司orgId
	 */
	private Integer importOrgId;
	/**
	 * 导入方公司orgName
	 */
	@Field(analyzer = "ik",searchAnalyzer = "ik", type = FieldType.String)
	private String importOrgName;
	/**
	 * 导出方公司orgid
	 */
	private Integer bindOrgId;
	/**
	 * 导出方公司名称 htg 2015年9月10日 YJHL201509A
	 */
	@Field(analyzer = "ik",searchAnalyzer = "ik", type = FieldType.String)
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
	@Field(type = FieldType.Date)
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
	@Field(type = FieldType.Date)
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
	 * 申请来源,0代表网页端;1代表客户端
	 */
	private Integer applySource;

	@Field(index = FieldIndex.no,type = FieldType.String)
	private String displayName; // 展示的名称(高亮)

	@Field(index = FieldIndex.no,type = FieldType.String)
	private String displayBindName; // 展示的名称(高亮)

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
	 * @param
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayBindName() {
		return displayBindName;
	}

	public void setDisplayBindName(String displayBindName) {
		this.displayBindName = displayBindName;
	}
}
