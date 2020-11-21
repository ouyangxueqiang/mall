package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Users;

public interface UsersDao {
    int deleteById(Integer id);//����idɾ��

    int insert(Users record);//�¼��û�

    int insertSelective(Users record);

    Users selectById(Integer id);//����id�����û�

    int updateByIdSelective(Users record);

    int updateById(Users record);  //�����û�  
    
    
	/**
	 * ��������ģ�������û�
	 * @param username
	 * @return
	 */
    @Select("select * from users where username like #{username} order by id asc")
	public List<Users> getListByName(@Param("username")String username);
	
	/**
	 * �������Ʋ����û��Ƿ����
	 * @param username
	 * @return
	 */
    @Select("select * from users where username=#{username}")
	public Users isExist(@Param("username")String username);
    
	/**
	 * �������Ʋ����û�
	 * @param username
	 * @return
	 */
    @Select("select * from users where username=#{username}")
	public Users selectByUsername(@Param("username")String username);
    
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @return 
	 */
    @Select("select * from users where username=#{username} and password=#{password}")
	public Users getByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
	
	/**
	 * ��ѯ�����û���Ϣ
	 * @return 
	 */
    @Select("select * from users order by id asc")
	public List<Users> getList();

	/**
	 * ��ѯ�û�����
	 * @return
	 */
    @Select("select count(*) from users")
	public int getTotal();
	
    
}