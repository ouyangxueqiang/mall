package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.entity.Goods;

public interface GoodsDao {
    int deleteById(Integer id);//ɾ����Ʒ   

    int insert(Goods record);//�¼���Ʒ

    int insertSelective(Goods record);

    Goods selectById(Integer id);

    int updateByIdSelective(Goods record);

    int updateById(Goods record);//�޸���Ʒ
    
    
	/**
	 * ��ȡ������Ʒ��Ϣ
	 * @return
	 */
    @Select("select * from goods order by id asc")
	public List<Goods> getList();
	
	/**
	 * ��ȡ������Ʒ����
	 * @return
	 */
    @Select("select count(*) from goods")
	public int getTotal();
	
	/**
	 * �������Ʋ�����Ʒ
	 * @param name
	 * @return
	 */
    @Select("select * from goods where name like #{name}")
	public List<Goods> getListByName(@Param("name")String name);
    
	/**
	 * ���ݱ�Ų�����Ʒ
	 * @param id
	 * @return
	 */
    @Select("select * from goods where id = #{id}")
	public Goods getListById(@Param("id")int id);
    
	/**
	 * �������Ͳ�����Ʒ
	 * @param typeId
	 * @return
	 */
    @Select("select * from goods where type_id = #{typeId}")
	public List<Goods> getListByTypeId(@Param("typeId")int typeId);
}