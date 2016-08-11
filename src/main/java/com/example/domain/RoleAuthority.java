package com.example.domain;
import java.io.Serializable;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class RoleAuthority implements Serializable {

	/****/
	private Long id;

	/**权限**/
	private Long authority;

	/**角色**/
	private Long role;



	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setAuthority(Long authority){
		this.authority = authority;
	}

	public Long getAuthority(){
		return this.authority;
	}

	public void setRole(Long role){
		this.role = role;
	}

	public Long getRole(){
		return this.role;
	}

}
