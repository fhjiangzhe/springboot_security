package com.example.mapper;

import com.example.domain.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * UserRoleMapper数据库操作接口类
 * 
 **/

public interface UserRoleMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	UserRole  selectByPrimaryKey ( @Param("id") Long id );

	/**
	 * 
	 * 删除（根据主键ID删除）
	 * 
	 **/
	int deleteByPrimaryKey ( @Param("id") Long id );

	List<UserRole> selectByMap(Map map);

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert( UserRole record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertSelective( UserRole record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( UserRole record );

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	int updateByPrimaryKey ( UserRole record );

}