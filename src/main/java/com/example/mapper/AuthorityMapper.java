package com.example.mapper;

import com.example.domain.Authority;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * AuthorityMapper数据库操作接口类
 * 
 **/

public interface AuthorityMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	Authority  selectByPrimaryKey ( @Param("id") Long id );


	List<Authority> selectAll();

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
	int insert( Authority record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertSelective( Authority record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( Authority record );

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	int updateByPrimaryKey ( Authority record );

}