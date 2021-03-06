package com.landasoft.excelcontactsorcl.mapper;

import com.landasoft.excelcontactsorcl.pojo.TItemInfo;
import com.landasoft.excelcontactsorcl.pojo.TItemInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TItemInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    int countByExample(TItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    int deleteByExample(TItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    int insert(TItemInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    int insertSelective(TItemInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    List<TItemInfo> selectByExampleWithBLOBs(TItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    List<TItemInfo> selectByExample(TItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    TItemInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    int updateByExampleSelective(@Param("record") TItemInfo record, @Param("example") TItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") TItemInfo record, @Param("example") TItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    int updateByExample(@Param("record") TItemInfo record, @Param("example") TItemInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    int updateByPrimaryKeySelective(TItemInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(TItemInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ITEM_INFO
     *
     * @mbggenerated Sun Jul 05 00:06:57 CST 2020
     */
    int updateByPrimaryKey(TItemInfo record);
}