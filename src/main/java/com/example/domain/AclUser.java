package com.example.domain;
import java.io.Serializable;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class AclUser implements Serializable {

	/****/
	private Long id;

	/**帐户是否过期**/
	private Integer accountEnabled;

	/**帐户是否锁住**/
	private Integer accountLocked;

	/**凭证是否过期**/
	private Integer credentialsExpired;

	/**描述**/
	private String description;

	/**全名**/
	private String fullName;

	/**手机号**/
	private String mobile;

	/**密码**/
	private String password;

	/**用户类型**/
	private Integer userMgrType;

	/**用户名**/
	private String username;

	/**所属部门**/
	private Long org;

	/**过期时间**/
	private String expiredDate;



	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setAccountEnabled(Integer accountEnabled){
		this.accountEnabled = accountEnabled;
	}

	public Integer getAccountEnabled(){
		return this.accountEnabled;
	}

	public void setAccountLocked(Integer accountLocked){
		this.accountLocked = accountLocked;
	}

	public Integer getAccountLocked(){
		return this.accountLocked;
	}

	public void setCredentialsExpired(Integer credentialsExpired){
		this.credentialsExpired = credentialsExpired;
	}

	public Integer getCredentialsExpired(){
		return this.credentialsExpired;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setFullName(String fullName){
		this.fullName = fullName;
	}

	public String getFullName(){
		return this.fullName;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return this.mobile;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setUserMgrType(Integer userMgrType){
		this.userMgrType = userMgrType;
	}

	public Integer getUserMgrType(){
		return this.userMgrType;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setOrg(Long org){
		this.org = org;
	}

	public Long getOrg(){
		return this.org;
	}

	public void setExpiredDate(String expiredDate){
		this.expiredDate = expiredDate;
	}

	public String getExpiredDate(){
		return this.expiredDate;
	}

}
