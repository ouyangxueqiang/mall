package com.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Admins;

public interface AdminsDao {
    int deleteById(Integer id);

    int insert(Admins record);

    int insertSelective(Admins record);

    Admins selectById(Integer id);

    int updateByIdSelective(Admins record);

    int updateById(Admins record);//����idֵ�޸Ĺ���Ա����
	
	/**
	 * �û���¼
	 */
    @Select("select * from admins where username=#{username} and password=#{password}")
	public Admins getByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
}