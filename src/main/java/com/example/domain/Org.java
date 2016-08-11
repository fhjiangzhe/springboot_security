package com.example.domain;
import java.io.Serializable;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class Org implements Serializable {

	/****/
	private Long id;

	/**描述**/
	private String description;

	/**部门名称**/
	private String orgName;

	/**部门编号**/
	private String orgNum;

	/**部门管理员**/
	private Long manager;

	/**父部门**/
	private Long parentorg;



	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setOrgName(String orgName){
		this.orgName = orgName;
	}

	public String getOrgName(){
		return this.orgName;
	}

	public void setOrgNum(String orgNum){
		this.orgNum = orgNum;
	}

	public String getOrgNum(){
		return this.orgNum;
	}

	public void setManager(Long manager){
		this.manager = manager;
	}

	public Long getManager(){
		return this.manager;
	}

	public void setParentorg(Long parentorg){
		this.parentorg = parentorg;
	}

	public Long getParentorg(){
		return this.parentorg;
	}

}
