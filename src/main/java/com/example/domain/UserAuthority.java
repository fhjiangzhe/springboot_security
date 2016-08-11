package com.example.domain;
import java.io.Serializable;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class UserAuthority implements Serializable {

	/****/
	private Long id;

	/****/
	private Long authority;

	/****/
	private Long roleAuthority;

	/****/
	private Long securityuser;


	private Authority authorityObj;

	public Authority getAuthorityObj() {
		return authorityObj;
	}

	public void setAuthorityObj(Authority authorityObj) {
		this.authorityObj = authorityObj;
	}

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

	public void setRoleAuthority(Long roleAuthority){
		this.roleAuthority = roleAuthority;
	}

	public Long getRoleAuthority(){
		return this.roleAuthority;
	}

	public void setSecurityuser(Long securityuser){
		this.securityuser = securityuser;
	}

	public Long getSecurityuser(){
		return this.securityuser;
	}

}
