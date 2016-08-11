package com.example.mapper;

import com.example.domain.AclUser;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * UserMapper数据库操作接口类
 * 
 **/

public interface UserMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	AclUser selectByPrimaryKey (@Param("id") Long id );

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
	int insert( AclUser record );

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertSelective( AclUser record );

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective( AclUser record );

	/**
	 * 
	 * 修改（根据主键ID修改）
	 * 
	 **/
	int updateByPrimaryKey ( AclUser record );


	/**
	 * 根据用户名查找
	 * @param name
	 * @return
     */
	AclUser findByName(@Param("username") String name);

}