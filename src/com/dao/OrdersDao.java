package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Orders;

public interface OrdersDao {
    int deleteById(Integer id);

    int insert(Orders record);//�����¹����¼

    int insertSelective(Orders record);

    Orders selectById(Integer id);

    int updateByIdSelective(Orders record);

    int updateById(Orders record);  
    
    /**
     * �������н��׼�¼
     */
    @Select("select * from orders")
    public List<Orders> getList();
    
    /**
     * �����û�id���ҽ��׼�¼
     */
    @Select("select * from orders where user_id=#{userId}")
    public List<Orders> getListById(@Param("userId")int userId);

}