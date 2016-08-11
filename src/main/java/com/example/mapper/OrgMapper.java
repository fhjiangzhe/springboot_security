package com.example.mapper;

import com.example.domain.Org;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * OrgMapper数据库操作接口类
 * 
 **/

public interface OrgMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Org  selectByPrimaryKey ( @Param("id") Long id );

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
	int insert( Org record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertSelective( Org record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Org record );

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	int updateByPrimaryKey ( Org record );

}