package com.example.mapper;

import com.example.domain.RoleAuthority;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * RoleauthorityMapper数据库操作接口类
 * 
 **/

public interface RoleAuthorityMapper {


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	RoleAuthority selectByPrimaryKey (@Param("id") Long id );

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
	int insert( RoleAuthority record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertSelective( RoleAuthority record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( RoleAuthority record );

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	int updateByPrimaryKey ( RoleAuthority record );

}