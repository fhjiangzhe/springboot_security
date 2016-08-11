package com.example.domain;
import java.io.Serializable;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class Role implements Serializable {

	/****/
	private Long id;

	/**描述**/
	private String description;

	/**显示名称**/
	private String displayref;

	/**角色名称**/
	private String name;



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

	public void setDisplayref(String displayref){
		this.displayref = displayref;
	}

	public String getDisplayref(){
		return this.displayref;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

}
