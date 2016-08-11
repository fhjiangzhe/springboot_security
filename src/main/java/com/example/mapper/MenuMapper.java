package com.example.mapper;

import com.example.domain.Menu;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * MenuMapper数据库操作接口类
 * 
 **/

public interface MenuMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Menu  selectByPrimaryKey ( @Param("id") Long id );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param("id") Long id );

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( Menu record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertSelective( Menu record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Menu record );

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	int updateByPrimaryKey ( Menu record );

}