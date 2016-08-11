package com.example.domain;
import java.io.Serializable;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class Menu implements Serializable {

	/****/
	private Long id;

	/**是否打开，在菜单树中使用**/
	private Integer expanded;

	/**是否是父菜单**/
	private Integer isParent;

	/**是否是子菜单**/
	private Integer leaf;

	/**菜单名称**/
	private String text;

	/**绑定地址**/
	private String url;

	/**父菜单**/
	private Long parentMenu;

	/**展示顺序**/
	private Integer sort;



	public void setId(Long id){
		this.id = id;
	}

	public Long getId(){
		return this.id;
	}

	public void setExpanded(Integer expanded){
		this.expanded = expanded;
	}

	public Integer getExpanded(){
		return this.expanded;
	}

	public void setIsParent(Integer isParent){
		this.isParent = isParent;
	}

	public Integer getIsParent(){
		return this.isParent;
	}

	public void setLeaf(Integer leaf){
		this.leaf = leaf;
	}

	public Integer getLeaf(){
		return this.leaf;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return this.text;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return this.url;
	}

	public void setParentMenu(Long parentMenu){
		this.parentMenu = parentMenu;
	}

	public Long getParentMenu(){
		return this.parentMenu;
	}

	public void setSort(Integer sort){
		this.sort = sort;
	}

	public Integer getSort(){
		return this.sort;
	}

}
