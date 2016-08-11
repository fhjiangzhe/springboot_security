/**
 * 
 */
package com.example.domain.mongo;

import java.io.Serializable;

/**
 * @ClassName: EnquiryOrgInfo 
 * @Description: 
 * @author 张昌苗
 * @date 2016年5月25日 下午1:54:50 
 * @version V1.0    
 */
public class EnquiryOrgInfo implements Serializable {

	private static final long serialVersionUID = -3229975942357954278L;

	private Long orgId; // 庄家id
	private Long bindNum; // 被互联的公司数量
	private Long efclDischargeportNum; // 整箱目的港数量
	private Long efclPriceNum; // 整箱运价数量
	
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Long getBindNum() {
		return bindNum;
	}
	public void setBindNum(Long bindNum) {
		this.bindNum = bindNum;
	}
	public Long getEfclDischargeportNum() {
		return efclDischargeportNum;
	}
	public void setEfclDischargeportNum(Long efclDischargeportNum) {
		this.efclDischargeportNum = efclDischargeportNum;
	}
	public Long getEfclPriceNum() {
		return efclPriceNum;
	}
	public void setEfclPriceNum(Long efclPriceNum) {
		this.efclPriceNum = efclPriceNum;
	}
}
