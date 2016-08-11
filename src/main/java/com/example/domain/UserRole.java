package com.example.domain;
import java.io.Serializable;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class UserRole implements Serializable {

	/****/
	private Long id;

	/****/
	private Long role;

	/****/
	private Long securityuser;



	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setRole(Long role){
		this.role = role;
	}

	public Long getRole(){
		return this.role;
	}

	public void setSecurityuser(Long securityuser){
		this.securityuser = securityuser;
	}

	public Long getSecurityuser(){
		return this.securityuser;
	}

}
