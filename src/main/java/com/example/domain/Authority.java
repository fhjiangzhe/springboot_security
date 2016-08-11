package com.example.domain;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class Authority implements Serializable,GrantedAuthority {

	/****/
	private Long id;

	/**权限名称**/
	private String authorityname;

	/**权限种类 1:列表 2:保存  3:删除**/
	private Integer authoritytype;

	/**描述**/
	private String description;

	/**显示名称**/
	private String displayref;

	/**所属菜单**/
	private Long menu;


	private Menu menuLink;

	@Override
	public String getAuthority() {
		return this.authorityname;
	}

	public Menu getMenuLink() {
		return menuLink;
	}

	public void setMenuLink(Menu menuLink) {
		this.menuLink = menuLink;
	}

	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setAuthorityname(String authorityname){
		this.authorityname = authorityname;
	}

	public String getAuthorityname(){
		return this.authorityname;
	}

	public void setAuthoritytype(Integer authoritytype){
		this.authoritytype = authoritytype;
	}

	public Integer getAuthoritytype(){
		return this.authoritytype;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

	public void setDisplayref(String displayref){
		this.displayref = displayref;
	}

	public String getDisplayref(){
		return this.displayref;
	}

	public void setMenu(Long menu){
		this.menu = menu;
	}

	public Long getMenu(){
		return this.menu;
	}

}
